// Generated from java-escape by ANTLR 4.11.1
package org.example.narwhal;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NarwhalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NarwhalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(NarwhalParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(NarwhalParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(NarwhalParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(NarwhalParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAssign(NarwhalParser.ExprAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readInt}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadInt(NarwhalParser.ReadIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readReal}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadReal(NarwhalParser.ReadRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code call}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(NarwhalParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(NarwhalParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code repeat}
	 * labeled alternative in {@link NarwhalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat(NarwhalParser.RepeatContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(NarwhalParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(NarwhalParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(NarwhalParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx(NarwhalParser.ExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(NarwhalParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code real}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal(NarwhalParser.RealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link NarwhalParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(NarwhalParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#lp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLp(NarwhalParser.LpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp(NarwhalParser.RpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(NarwhalParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(NarwhalParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(NarwhalParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(NarwhalParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(NarwhalParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#equal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(NarwhalParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#blockif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockif(NarwhalParser.BlockifContext ctx);
	/**
	 * Visit a parse tree produced by {@link NarwhalParser#repetitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepetitions(NarwhalParser.RepetitionsContext ctx);
}