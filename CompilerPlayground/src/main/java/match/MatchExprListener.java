// Generated from H:/Workspace/CompilerPlayground/src/main/java/play/MatchExpr.g4 by ANTLR 4.13.2
package match;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MatchExprParser}.
 */
public interface MatchExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MatchExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MatchExprParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatchExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MatchExprParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatchExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MatchExprParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatchExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MatchExprParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatchExprParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(MatchExprParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatchExprParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(MatchExprParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatchExprParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(MatchExprParser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatchExprParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(MatchExprParser.FloatLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatchExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MatchExprParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatchExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MatchExprParser.PrimaryContext ctx);
}