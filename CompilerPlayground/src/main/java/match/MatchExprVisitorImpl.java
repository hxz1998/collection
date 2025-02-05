/**
 * CompilerPlayground
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2024/10/15
 **/
package match;

import match.MatchExprParser.ExpressionContext;
import match.MatchExprParser.FloatLiteralContext;
import match.MatchExprParser.IntegerLiteralContext;
import match.MatchExprParser.LiteralContext;
import match.MatchExprParser.PrimaryContext;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MatchExprVisitorImpl extends MatchExprBaseVisitor<Object> {

    @Override
    public Object visitExpression(ExpressionContext ctx) {
        print("访问了表达式：" + ctx.getText());
        return super.visitExpression(ctx);
    }

    @Override
    public Object visitLiteral(LiteralContext ctx) {
        return super.visitLiteral(ctx);
    }

    @Override
    public Object visitIntegerLiteral(IntegerLiteralContext ctx) {
        return super.visitIntegerLiteral(ctx);
    }

    @Override
    public Object visitFloatLiteral(FloatLiteralContext ctx) {
        print("访问了浮点数：" + ctx.toString());
        return super.visitFloatLiteral(ctx);
    }

    @Override
    public Object visitPrimary(PrimaryContext ctx) {
        print("访问了基础类型：" + ctx.toString());
        return super.visitPrimary(ctx);
    }

    private void print(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        String expr = "a.b";
        MatchExprLexer lexer = new MatchExprLexer(CharStreams.fromString(expr));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        MatchExprParser parser = new MatchExprParser(tokens);
        ParseTree tree = parser.expression();
        MatchExprVisitorImpl visitor = new MatchExprVisitorImpl();
        Object result = visitor.visit(tree);
        System.out.println(result);
    }
}
