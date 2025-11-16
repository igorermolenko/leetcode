package com.leetcode;

import java.util.Stack;

public class RemoveStars {

    public String removeStars2(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c != '*') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public String removeStars(String s) {
        char[] chars = s.toCharArray();
        int position = 0;
        for (char ch: chars) {
            if (position > 0 && ch == '*') {
                position--;
            } else  {
                chars[position++] = ch;
            }
        }
        return String.valueOf(chars, 0, position);
    }


    public static void main(String[] args) {
        RemoveStars stars = new RemoveStars();
        System.out.println(stars.removeStars("leet**cod*e"));
        System.out.println(stars.removeStars("erase*****"));
    }
}
