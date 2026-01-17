package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            chars.put(ch, chars.getOrDefault(ch, 0) + 1);
        }
        for (char ch : ransomNote.toCharArray()) {
            int charCounter = chars.getOrDefault(ch, 0);
            if (charCounter == 0) {
                return false;
            }
            chars.put(ch, charCounter - 1);
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (char ch : magazine.toCharArray()) {
            chars[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (chars[ch - 'a'] == 0) {
                return false;
            }
            chars[ch - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote task = new RansomNote();
        System.out.println(task.canConstruct("a", "b"));
        System.out.println(task.canConstruct("aa", "ab"));
        System.out.println(task.canConstruct("aa", "aab"));

    }
}
