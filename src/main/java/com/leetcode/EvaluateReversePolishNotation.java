package com.leetcode;

import java.util.*;

public class EvaluateReversePolishNotation {
    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                int operand2 = deque.pop();
                int operand1 = deque.pop();
                deque.push(executeOperation(operand1, operand2, token));
            } else {
                deque.push(Integer.parseInt(token));
            }
        }
        return deque.pop();
    }

    private int executeOperation(int operand1, int operand2, String operator) {
        return switch (operator) {
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            default -> throw new IllegalArgumentException();
        };
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation task = new EvaluateReversePolishNotation();
        System.out.println(task.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(task.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(task.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
