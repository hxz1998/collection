// Generated from java-escape by ANTLR 4.11.1
package org.example.narwhal;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NarwhalParser}.
 */
public interface NarwhalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(NarwhalParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(NarwhalParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(NarwhalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(NarwhalParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrint(NarwhalParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrint(NarwhalParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(NarwhalParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(NarwhalParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign(NarwhalParser.ExprAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign(NarwhalParser.ExprAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readInt}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReadInt(NarwhalParser.ReadIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readInt}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReadInt(NarwhalParser.ReadIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readReal}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReadReal(NarwhalParser.ReadRealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readReal}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReadReal(NarwhalParser.ReadRealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code call}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterCall(NarwhalParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code call}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitCall(NarwhalParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIf(NarwhalParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIf(NarwhalParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code repeat}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterRepeat(NarwhalParser.RepeatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code repeat}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitRepeat(NarwhalParser.RepeatContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(NarwhalParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(NarwhalParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(NarwhalParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(NarwhalParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(NarwhalParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(NarwhalParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ex}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterEx(NarwhalParser.ExContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ex}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitEx(NarwhalParser.ExContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterInt(NarwhalParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitInt(NarwhalParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code real}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterReal(NarwhalParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code real}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitReal(NarwhalParser.RealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterId(NarwhalParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitId(NarwhalParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#lp}.
	 * @param ctx the parse tree
	 */
	void enterLp(NarwhalParser.LpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#lp}.
	 * @param ctx the parse tree
	 */
	void exitLp(NarwhalParser.LpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp(NarwhalParser.RpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp(NarwhalParser.RpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(NarwhalParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(NarwhalParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSub(NarwhalParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSub(NarwhalParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(NarwhalParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(NarwhalParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#div}.
	 * @param ctx the parse tree
	 */
	void enterDiv(NarwhalParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#div}.
	 * @param ctx the parse tree
	 */
	void exitDiv(NarwhalParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(NarwhalParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(NarwhalParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#equal}.
	 * @param ctx the parse tree
	 */
	void enterEqual(NarwhalParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#equal}.
	 * @param ctx the parse tree
	 */
	void exitEqual(NarwhalParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#blockif}.
	 * @param ctx the parse tree
	 */
	void enterBlockif(NarwhalParser.BlockifContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#blockif}.
	 * @param ctx the parse tree
	 */
	void exitBlockif(NarwhalParser.BlockifContext ctx);
	/**
	 * Enter a parse tree produced by {@link NarwhalParser#repetitions}.
	 * @param ctx the parse tree
	 */
	void enterRepetitions(NarwhalParser.RepetitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NarwhalParser#repetitions}.
	 * @param ctx the parse tree
	 */
	void exitRepetitions(NarwhalParser.RepetitionsContext ctx);
}