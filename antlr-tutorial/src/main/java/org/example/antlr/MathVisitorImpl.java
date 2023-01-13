/**
 * antlr-tutorial
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/11/14
 **/
package org.example.antlr;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MathVisitorImpl extends MathBaseVisitor<Integer> {
    private final Map<String, Integer> memory = new HashMap<>();

    @Override
    public Integer visitPrintExpr(MathParser.PrintExprContext ctx) {
        log.info("print: {}", visit(ctx.expr()));
        return 0;
    }

    @Override
    public Integer visitAssign(MathParser.AssignContext ctx) {
        log.info("访问赋值");
        String id = ctx.ID().getText();
        Integer value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Integer visitId(MathParser.IdContext ctx) {
        String id = ctx.ID().getText();
        return memory.getOrDefault(id, 0);
    }

    @Override
    public Integer visitMulDiv(MathParser.MulDivContext ctx) {
        log.info("访问乘除");
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));
        if (ctx.oper.getType() == MathParser.MUL) {
            return left * right;
        } else {
            return left / right;
        }
    }

    @Override
    public Integer visitSingleStatement(MathParser.SingleStatementContext ctx) {
        log.info("single statement: {}", visit(ctx.expr()));
        return 0;
    }

    @Override
    public Integer visitAddSub(MathParser.AddSubContext ctx) {
        log.info("访问加减");
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));
        if (ctx.oper.getType() == MathParser.ADD) {
            return left + right;
        } else {
            return left - right;
        }
    }

    @Override
    public Integer visitParens(MathParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitInt(MathParser.IntContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }
}
