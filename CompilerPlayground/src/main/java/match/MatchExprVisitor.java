// Generated from H:/Workspace/CompilerPlayground/src/main/java/play/MatchExpr.g4 by ANTLR 4.13.2
package match;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MatchExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MatchExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MatchExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MatchExprParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatchExprParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MatchExprParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatchExprParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(MatchExprParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatchExprParser#floatLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(MatchExprParser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatchExprParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(MatchExprParser.PrimaryContext ctx);
}