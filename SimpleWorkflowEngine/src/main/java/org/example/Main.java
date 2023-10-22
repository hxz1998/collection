package org.example;

import org.example.workflow.engine.Data;
import org.example.workflow.engine.SimpleWorkflowEngine;
import org.example.workflow.engine.impl.IntegerDecreaseProcess;
import org.example.workflow.engine.impl.IntegerIncreaseProcess;
import org.example.workflow.engine.impl.PrintProcess;

/**
 * Default (Template) Project
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/21
 **/
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        SimpleWorkflowEngine<Integer> engine = new SimpleWorkflowEngine<>();
        engine.addWorkflow("increase", new IntegerIncreaseProcess());
        engine.addWorkflow("decrease", new IntegerDecreaseProcess());
        engine.addWorkflow("print", new PrintProcess<>());

        engine.execute(new String[]{"increase", "increase", "increase", "increase", "increase", "decrease", "increase", "print"}, new Data<>(1));
    }
}