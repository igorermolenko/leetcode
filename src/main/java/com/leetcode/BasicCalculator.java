package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class BasicCalculator {
    private static final Set<Character> OPERATORS = Set.of('+', '-');

    public int calculate1(String s) {
        int len = s.length();
        Integer operand1 = null, operand2 = null;
        Character operator = null;

        int i = 0;

        while (i < len) {
            char ch = s.charAt(i);
            if (ch == '(') {
                int openBracketsCount = 1;
                int j = i + 1;
                while (openBracketsCount > 0) {
                    switch (s.charAt(j)) {
                        case ')' -> openBracketsCount--;
                        case '(' -> openBracketsCount++;
                    }
                    j++;
                }
                int result = calculate(s.substring(i + 1, j - 1));

                if (operator != null && operator == '-' && operand1 == null) {
                    operand1 = -result;
                    operator = null;
                } else if (operand1 == null) {
                    operand1 = result;
                } else {
                    operand2 = result;
                }
                i = j;
            } else if (OPERATORS.contains(ch)) {
                operator = ch;
                i++;
            } else if (Character.isDigit(ch)) {
                int j = i + 1;
                while (j < len && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                String numberStr = s.substring(i, j);
                if (operator != null && operand1 == null) {
                    operand1 = Integer.parseInt(operator + numberStr);
                    operator = null;
                } else if (operand1 == null) {
                    operand1 = Integer.parseInt(numberStr);
                } else {
                    operand2 = Integer.parseInt(numberStr);
                }
                i = j;
            } else {
                i++;
            }

            if (operand1 != null && operand2 != null && operator != null) {
                operand1 = operator == '+' ? operand1 + operand2 : operand1 - operand2;
                operand2 = null;
                operator = null;
            }
        }
        return operand1;
    }


    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int num = 0;
        int sign = 1;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+' || ch == '-') {
                result += sign * num;
                num = 0;
                sign = ch == '+' ? 1 : -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                num = 0;
                sign = 1;
            } else if (ch == ')') {
                num = result + sign * num;
                sign = stack.pop();
                result = stack.pop();
            }
        }
        return result + sign * num;
    }


    public static void main(String[] args) {
        BasicCalculator task = new BasicCalculator();
        System.out.println(task.calculate("- (3 + (4 + 5))"));
        System.out.println(task.calculate("-2147483648"));
        System.out.println(task.calculate("1-(     -2)"));
        System.out.println(task.calculate("1 + 1"));
        System.out.println(task.calculate(" 2-1 + 2 "));
        System.out.println(task.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
