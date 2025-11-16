package com.leetcode;

public class StringCompression {

    public int compress(char[] chars) {
        int position = 0;
        char currentChar = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == currentChar) {
                count++;
            } else {
                position = writeChars(chars, position, currentChar, count);
                currentChar = chars[i];
                count = 1;
            }
        }
        return writeChars(chars, position, currentChar, count);
    }

    int writeChars(char[] chars, int position, char ch, int count) {
        chars[position++] = ch;
        if (count > 1) {
            for(char digit: Integer.toString(count).toCharArray()) {
                chars[position++] = digit;
            }
        }
        return position;
    }


    public static void main(String[] args) {
        StringCompression compression = new StringCompression();
        System.out.println(compression.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(compression.compress(new char[]{'a'}));
        System.out.println(compression.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }
}
