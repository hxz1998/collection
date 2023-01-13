/**
 * antlr-tutorial
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/11/14
 **/
package org.example.sql;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SqlBaseVisitorImpl extends SqlBaseBaseVisitor<String> {

    private StringBuilder builder = new StringBuilder();

    @Override
    public String visitSelectStatement(SqlBaseParser.SelectStatementContext ctx) {
        visit(ctx.selectElements());
        visit(ctx.fromClause());
        visit(ctx.whereClause());
        log.info("选择语句：{}", builder.toString());
        return builder.toString();
    }

    @Override
    public String visitDeleteStatement(SqlBaseParser.DeleteStatementContext ctx) {
        return super.visitDeleteStatement(ctx);
    }

    @Override
    public String visitUpdateStatement(SqlBaseParser.UpdateStatementContext ctx) {
        return super.visitUpdateStatement(ctx);
    }

    @Override
    public String visitInsertStatement(SqlBaseParser.InsertStatementContext ctx) {
        return super.visitInsertStatement(ctx);
    }

    @Override
    public String visitFromClause(SqlBaseParser.FromClauseContext ctx) {
        builder.append("从 ").append(ctx.tableName().LETTER()).append(" 表中获取");
        return super.visitFromClause(ctx);
    }

    @Override
    public String visitWhereClause(SqlBaseParser.WhereClauseContext ctx) {
        builder.append("条件是：");
        return super.visitWhereClause(ctx);
    }

    @Override
    public String visitSelectElements(SqlBaseParser.SelectElementsContext ctx) {
        return super.visitSelectElements(ctx);
    }

    @Override
    public String visitDeleteElements(SqlBaseParser.DeleteElementsContext ctx) {
        return super.visitDeleteElements(ctx);
    }

    @Override
    public String visitUpdateElements(SqlBaseParser.UpdateElementsContext ctx) {
        return super.visitUpdateElements(ctx);
    }

    @Override
    public String visitInsertElements(SqlBaseParser.InsertElementsContext ctx) {
        return super.visitInsertElements(ctx);
    }

    @Override
    public String visitTableName(SqlBaseParser.TableNameContext ctx) {
        return super.visitTableName(ctx);
    }

    @Override
    public String visitSpecificElements(SqlBaseParser.SpecificElementsContext ctx) {
        builder.append(ctx.KEY()).append("=").append(ctx.TARGET());
        return null;
    }
}
