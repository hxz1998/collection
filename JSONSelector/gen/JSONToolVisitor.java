// Generated from H:/Workspace/JSONSelector/antlr4\JSONTool.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JSONToolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JSONToolVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JSONToolParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(JSONToolParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSONToolParser#compareRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareRule(JSONToolParser.CompareRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSONToolParser#keyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyList(JSONToolParser.KeyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSONToolParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(JSONToolParser.KeyContext ctx);
}