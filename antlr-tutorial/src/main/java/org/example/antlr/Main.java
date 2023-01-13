package org.example.antlr;


import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

@Slf4j
public class Main {
    public static void main(String[] args) throws IOException {
        CharStream inputStream = CharStreams.fromFileName("data.txt");
        MathLexer lexer = new MathLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        MathParser parser = new MathParser(tokenStream);
        MathParser.ProgContext parseContext = parser.prog();

        MathVisitorImpl visitor = new MathVisitorImpl();
        visitor.visit(parseContext);
        log.info(parseContext.toStringTree());
    }
}