package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generateParenthesis(n, new StringBuilder(), result, 0, 0);

        return result;
    }

    private void generateParenthesis(int n, StringBuilder current, List<String> result, int openCount, int closeCount) {
        if (current.length() == n * 2) {
            result.add(current.toString());
            return;
        }

        if (openCount < n) {
            current.append('(');
            generateParenthesis(n, current, result, openCount + 1, closeCount);
            current.deleteCharAt(current.length() - 1);
        }
        if (closeCount < openCount) {
            current.append(')');
            generateParenthesis(n, current, result, openCount, closeCount + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }


    public static void main(String[] args) {
        GenerateParentheses task = new GenerateParentheses();
        System.out.println(task.generateParenthesis(3));
        System.out.println(task.generateParenthesis(1));
    }
}
