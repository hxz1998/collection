/**
 * MicroVM
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
package org.example;

import java.util.List;

public class MicroVM {

    private int[] stack = new int[100];
    private int sp; // Stack pointer

    public void execute(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            switch (instruction.getOpcode()) {
                case OpCode.LOAD_CONST:
                    int value = instruction.getOperand();
                    push(value);
                    break;
                case OpCode.ADD:
                    int b = pop();
                    int a = pop();
                    push(a + b);
                    break;
                case OpCode.SUB:
                    int d = pop();
                    int c = pop();
                    push(c - d);
                    break;
                case OpCode.PRINT:
                    System.out.println(pop());
                    break;
                default:
                    throw new RuntimeException("Unknown opcode: " + instruction.getOpcode());
            }
        }
    }

    private void push(int value) {
        stack[sp++] = value;
    }

    private int pop() {
        return stack[--sp];
    }
}

class OpCode {

    public static final int LOAD_CONST = 1;
    public static final int ADD = 2;
    public static final int SUB = 3;
    public static final int PRINT = 4;
}

class Instruction {

    private int opcode;
    private int operand;

    public Instruction(int opcode, int operand) {
        this.opcode = opcode;
        this.operand = operand;
    }

    public int getOpcode() {
        return opcode;
    }

    public int getOperand() {
        return operand;
    }
}
