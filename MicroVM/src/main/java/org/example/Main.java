package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Default (Template) Project
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
public class Main {

    public static void main(String[] args) {
        List<Instruction> program = new ArrayList<>();
        program.add(new Instruction(OpCode.LOAD_CONST, 10));
        program.add(new Instruction(OpCode.LOAD_CONST, 20));
        program.add(new Instruction(OpCode.ADD, 0));
        program.add(new Instruction(OpCode.PRINT, 0));

        MicroVM vm = new MicroVM();
        vm.execute(program);
    }
}