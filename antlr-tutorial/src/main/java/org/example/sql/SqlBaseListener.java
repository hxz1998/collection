// Generated from H:/Workspace/antlr-tutorial/src/main/antlr4\SqlBase.g4 by ANTLR 4.10.1
package org.example.sql;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlBaseParser}.
 */
public interface SqlBaseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(SqlBaseParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(SqlBaseParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeleteStatement(SqlBaseParser.DeleteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeleteStatement(SqlBaseParser.DeleteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStatement(SqlBaseParser.UpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStatement(SqlBaseParser.UpdateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsertStatement(SqlBaseParser.InsertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsertStatement(SqlBaseParser.InsertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(SqlBaseParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(SqlBaseParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(SqlBaseParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(SqlBaseParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#selectElements}.
	 * @param ctx the parse tree
	 */
	void enterSelectElements(SqlBaseParser.SelectElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#selectElements}.
	 * @param ctx the parse tree
	 */
	void exitSelectElements(SqlBaseParser.SelectElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#deleteElements}.
	 * @param ctx the parse tree
	 */
	void enterDeleteElements(SqlBaseParser.DeleteElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#deleteElements}.
	 * @param ctx the parse tree
	 */
	void exitDeleteElements(SqlBaseParser.DeleteElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#updateElements}.
	 * @param ctx the parse tree
	 */
	void enterUpdateElements(SqlBaseParser.UpdateElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#updateElements}.
	 * @param ctx the parse tree
	 */
	void exitUpdateElements(SqlBaseParser.UpdateElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#insertElements}.
	 * @param ctx the parse tree
	 */
	void enterInsertElements(SqlBaseParser.InsertElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#insertElements}.
	 * @param ctx the parse tree
	 */
	void exitInsertElements(SqlBaseParser.InsertElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(SqlBaseParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(SqlBaseParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlBaseParser#specificElements}.
	 * @param ctx the parse tree
	 */
	void enterSpecificElements(SqlBaseParser.SpecificElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlBaseParser#specificElements}.
	 * @param ctx the parse tree
	 */
	void exitSpecificElements(SqlBaseParser.SpecificElementsContext ctx);
}