package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class BasicCalculatorII {
    private static final Set<Character> OPERATORS = Set.of('+', '-', '*', '/');


    public int calculate2(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int operand1 = 0, operand2 = 0;
        Character operation = null;

        stack.push(1);
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (operation == null) {
                    operand1 = operand1 * 10 + (ch - '0');
                } else {
                    operand2 = operand2 * 10 + (ch - '0');
                }
            } else if (ch == '+' || ch == '-') {
                if (operation != null) {
                    operand1 = operation == '*' ? operand1 * operand2 : operand1 / operand2;
                    operand2 = 0;
                    operation = null;
                }
                stack.push(operand1);
                stack.push(ch == '+' ? 1 : -1);
                operand1 = 0;
            } else if (ch == '*' || ch == '/') {
                if (operation != null) {
                    operand1 = operation == '*' ? operand1 * operand2 : operand1 / operand2;
                    operand2 = 0;
                }
                operation = ch;
            }
        }
        if (operation != null) {
            operand1 = operation == '*' ? operand1 * operand2 : operand1 / operand2;
        }
        stack.push(operand1);

        int result = 0;

        while (!stack.isEmpty()) {
            int number = stack.pop();
            int sign = stack.pop();
            result += number * sign;
        }

        return result;
    }


    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char operation = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (OPERATORS.contains(ch) || i == s.length() - 1) {
                switch (operation) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                operation = ch;
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {
        BasicCalculatorII task = new BasicCalculatorII();
        System.out.println(task.calculate("3 * 2 + 2"));
        System.out.println(task.calculate("3+2*2"));
        System.out.println(task.calculate(" 3/2 "));
        System.out.println(task.calculate(" 3+5 / 2 "));
    }
}
