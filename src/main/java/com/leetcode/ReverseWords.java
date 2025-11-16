package com.leetcode;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isBlank()) {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        ReverseWords words = new ReverseWords();
        System.out.println(words.reverseWords("the sky is blue") + ".");
        System.out.println(words.reverseWords("  hello world  ") + ".");
        System.out.println(words.reverseWords("a good   example") + ".");
    }
}
