// Generated from H:/Workspace/antlr-tutorial/src/main/antlr4\SqlBase.g4 by ANTLR 4.10.1
package org.example.sql;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SqlBaseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SqlBaseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(SqlBaseParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#deleteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatement(SqlBaseParser.DeleteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(SqlBaseParser.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(SqlBaseParser.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(SqlBaseParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(SqlBaseParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#selectElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectElements(SqlBaseParser.SelectElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#deleteElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteElements(SqlBaseParser.DeleteElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#updateElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateElements(SqlBaseParser.UpdateElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#insertElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertElements(SqlBaseParser.InsertElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(SqlBaseParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlBaseParser#specificElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecificElements(SqlBaseParser.SpecificElementsContext ctx);
}