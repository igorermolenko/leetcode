package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] words = s.split(" ");
        if (words.length != chars.length) return false;

        Map<Character, String> char2word = new HashMap<>();
        Map<String, Character> word2char = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            String w = words[i];

            String mappedWord = char2word.putIfAbsent(c, w);
            Character mappedChar = word2char.putIfAbsent(w, c);

            if ((mappedWord != null && !mappedWord.equals(w)) || (mappedChar != null && !mappedChar.equals(c))) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        WordPattern task = new WordPattern();
        System.out.println(task.wordPattern("abba", "dog cat cat dog"));
        System.out.println(task.wordPattern("abba", "dog cat cat fish"));
        System.out.println(task.wordPattern("aaaa", "dog cat cat dog"));
    }
}
