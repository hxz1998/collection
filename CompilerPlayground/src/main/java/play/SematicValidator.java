package play;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import play.PlayScriptParser.ClassDeclarationContext;
import play.PlayScriptParser.ExpressionContext;
import play.PlayScriptParser.FunctionCallContext;
import play.PlayScriptParser.FunctionDeclarationContext;
import play.PlayScriptParser.LiteralContext;
import play.PlayScriptParser.PrimaryContext;
import play.PlayScriptParser.StatementContext;
import play.PlayScriptParser.SwitchBlockStatementGroupContext;
import play.PlayScriptParser.VariableDeclaratorContext;
import play.PlayScriptParser.VariableDeclaratorIdContext;
import play.PlayScriptParser.VariableDeclaratorsContext;
import play.PlayScriptParser.VariableInitializerContext;

/**
 * 进行一些语义检查，包括：
 * 01.break 只能出现在循环语句中，或case语句中；
 * <p>
 * 02.return语句
 * 02-01 函数声明了返回值，就一定要有return语句。除非返回值类型是void。
 * 02-02 类的构造函数里如果用到return，不能带返回值。
 * 02-03 return语句只能出现在函数里。
 * 02-04 返回值类型检查 -> (在TypeChecker里做）
 * <p>
 * 03.左值
 * 03-01 标注左值（不标注就是右值)；
 * 03-02 检查表达式能否生成合格的左值。
 * <p>
 * 04.类的声明不能在函数里（TODO 未来应该也可以，只不过对生存期有要求）
 * <p>
 * 05.super()和this()，只能是构造函数中的第一句。  这个在RefResolver中实现了。
 * <p>
 * 06.
 */
public class SematicValidator extends PlayScriptBaseListener {

    private AnnotatedTree at = null;

    public SematicValidator(AnnotatedTree at) {
        this.at = at;
    }


    @Override
    public void exitPrimary(PrimaryContext ctx) {

    }


    @Override
    public void exitFunctionCall(FunctionCallContext ctx) {

    }


    @Override
    public void exitExpression(ExpressionContext ctx) {

    }


    @Override
    public void exitClassDeclaration(ClassDeclarationContext ctx) {
        // 04 类的声明不能在函数里
        if (at.enclosingFunctionOfNode(ctx) != null) {
            at.log("can not declare class inside function", ctx);
        }
    }

    @Override
    public void exitFunctionDeclaration(FunctionDeclarationContext ctx) {
        // 02-01 函数定义了返回值，就一定要有相应的return语句。
        // TODO 更完善的是要进行控制流计算，不是仅仅有一个return语句就行了。
        if (ctx.typeTypeOrVoid() != null) {
            if (!hasReturnStatement(ctx)) {
                Type returnType = at.typeOfNode.get(ctx.typeTypeOrVoid());
                if (!(returnType == VoidType.instance())) {
                    at.log("return statment expected in function", ctx);
                }
            }
        }
    }

    @Override
    public void exitVariableDeclarators(VariableDeclaratorsContext ctx) {
        super.exitVariableDeclarators(ctx);
    }

    @Override
    public void exitVariableDeclarator(VariableDeclaratorContext ctx) {
        super.exitVariableDeclarator(ctx);
    }

    @Override
    public void exitVariableDeclaratorId(VariableDeclaratorIdContext ctx) {
        super.exitVariableDeclaratorId(ctx);
    }

    // 对变量初始化部分也做一下类型推断
    @Override
    public void exitVariableInitializer(VariableInitializerContext ctx) {

    }

    // 根据字面量来推断类型
    @Override
    public void exitLiteral(LiteralContext ctx) {

    }

    @Override
    public void exitStatement(StatementContext ctx) {
        // 02 类的构造函数不能有返回值
        if (ctx.RETURN() != null) {
            // 02-03
            Function function = at.enclosingFunctionOfNode(ctx);
            if (function == null) {
                at.log("return statement not in function body", ctx);
            } else if (function.isConstructor() && ctx.expression() != null) {
                // 02-02 构造函数不能有return语句
                at.log("can not return a value from constructor", ctx);
            }
        }
        // 01 break语句
        else if (ctx.BREAK() != null) {
            if (!checkBreak(ctx)) {
                at.log("break statement not in loop or switch statements", ctx);
            }
        }
    }

    /**
     * 检查一个函数里有没有return语句。
     *
     * @param ctx
     * @return
     */
    private boolean hasReturnStatement(ParseTree ctx) {
        boolean rtn = false;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof StatementContext &&
                ((StatementContext) child).RETURN() != null) {
                rtn = true;
                break;
            } else if (!(child instanceof FunctionDeclarationContext ||
                child instanceof ClassDeclarationContext)) {
                rtn = hasReturnStatement(child);
                if (rtn) {
                    break;
                }
            }
        }
        return rtn;
    }

    /**
     * break只能出现在循环语句或switch-case语句里。
     *
     * @param ctx
     * @return
     */
    private boolean checkBreak(RuleContext ctx) {
        if (ctx.parent instanceof StatementContext &&
            (((StatementContext) ctx.parent).FOR() != null ||
                ((StatementContext) ctx.parent).WHILE() != null) ||
            ctx.parent instanceof SwitchBlockStatementGroupContext) {
            return true;
        } else if (ctx.parent == null || ctx.parent instanceof FunctionDeclarationContext) {
            return false;
        } else {
            return checkBreak(ctx.parent);
        }
    }

}