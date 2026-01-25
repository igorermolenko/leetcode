package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    private static final Map<Character, Character> PARENTHESES = Map.of(')', '(', ']', '[', '}', '{');

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (PARENTHESES.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != PARENTHESES.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        ValidParentheses task = new ValidParentheses();
        System.out.println(task.isValid("()"));
        System.out.println(task.isValid("()[]{}"));
        System.out.println(task.isValid("(]"));
        System.out.println(task.isValid("([])"));
        System.out.println(task.isValid("([)]"));
    }
}
