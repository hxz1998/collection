/**
 * antlr-tutorial
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/11/14
 **/
package org.example.mysql;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySQLParserVisitorImpl extends MySqlParserBaseVisitor<String> {
    @Override
    public String visitQueryExpression(MySqlParser.QueryExpressionContext ctx) {
        log.info("进行一个查询语言的操作");
        return super.visitQueryExpression(ctx);
    }

    @Override
    public String visitQuerySpecification(MySqlParser.QuerySpecificationContext ctx) {
        log.info("访问一个专属的方法");
        return super.visitQuerySpecification(ctx);
    }
}
