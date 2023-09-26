// Generated from H:/Workspace/JSONSelector/antlr4\JSONTool.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JSONToolParser}.
 */
public interface JSONToolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JSONToolParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(JSONToolParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONToolParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(JSONToolParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONToolParser#compareRule}.
	 * @param ctx the parse tree
	 */
	void enterCompareRule(JSONToolParser.CompareRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONToolParser#compareRule}.
	 * @param ctx the parse tree
	 */
	void exitCompareRule(JSONToolParser.CompareRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONToolParser#keyList}.
	 * @param ctx the parse tree
	 */
	void enterKeyList(JSONToolParser.KeyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONToolParser#keyList}.
	 * @param ctx the parse tree
	 */
	void exitKeyList(JSONToolParser.KeyListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONToolParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(JSONToolParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONToolParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(JSONToolParser.KeyContext ctx);
}