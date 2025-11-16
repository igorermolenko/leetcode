package com.leetcode;

import java.util.Stack;

public class DecodeString {

    public String decodeString2(String s) {
        StringBuilder result = new StringBuilder();

        int leftBracketsCount = 0;
        int countPos = -1;
        int leftBracketPos = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (countPos == -1) {
                if (Character.isDigit(ch)) {
                    countPos = i;
                } else {
                    result.append(ch);
                }
            }
            if (ch == '[') {
                if (leftBracketPos == -1) {
                    leftBracketPos = i;
                }
                leftBracketsCount++;
            } else if (ch == ']') {
                if (--leftBracketsCount == 0) {
                    int count = Integer.parseInt(s.substring(countPos, leftBracketPos));
                    String pattern = s.substring(leftBracketPos + 1, i);
                    result.append(decodePattern(count, pattern));
                    countPos = -1;
                    leftBracketPos = -1;
                }
            }
        }

        return result.toString();
    }

    private String decodePattern(int count, String pattern) {
        String str = decodeString(pattern);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(str);
        }
        return result.toString();
    }


    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int count = 0;
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[')  {
                countStack.push(count);
                stringStack.push(current);
                count = 0;
                current = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder decoded = stringStack.pop();
                int n = countStack.pop();
                for (int i = 0; i < n; i++) {
                    decoded.append(current);
                }
                current = decoded;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }



    public static void main(String[] args) {
        DecodeString decoder = new DecodeString();
        System.out.println(decoder.decodeString("3[a]2[bc]"));
        System.out.println(decoder.decodeString("3[ad2[c]]"));
        System.out.println(decoder.decodeString("3[a2[c]]"));
        System.out.println(decoder.decodeString("2[abc]3[cd]ef"));
        System.out.println(decoder.decodeString("prefix2[abc]suffix"));
        System.out.println(decoder.decodeString("15[a]"));
    }
}
