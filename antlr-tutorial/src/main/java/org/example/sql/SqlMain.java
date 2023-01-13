/**
 * antlr-tutorial
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/11/14
 **/
package org.example.sql;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class SqlMain {
    public static void main(String[] args) {
        CharStream input = CharStreams.fromString("select key from tb where (name)=[hu];");
        SqlBaseLexer lexer = new SqlBaseLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(tokens);
        SqlBaseParser.SelectStatementContext ctx = parser.selectStatement();
        SqlBaseVisitorImpl visitor = new SqlBaseVisitorImpl();
        visitor.visit(ctx);
    }
}
