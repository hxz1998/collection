/**
 * antlr-tutorial
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/11/14
 **/
package org.example.mysql;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class SQLEngine {
    public static void main(String[] args) {
        CharStream input = CharStreams.fromString("SELECT * FROM user;");
        MySqlLexer lexer = new MySqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MySqlParser parser = new MySqlParser(tokens);
        MySqlParser.QueryExpressionContext context = parser.queryExpression();
        MySqlParser.QuerySpecificationContext specificationContext = parser.querySpecification();
        MySQLParserVisitorImpl engine = new MySQLParserVisitorImpl();
        // engine.visitQueryExpression(context);
        engine.visitQuerySpecification(specificationContext);
    }
}
