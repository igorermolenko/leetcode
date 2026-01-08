package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> symbols = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (symbols.contains(s.charAt(right))) {
                symbols.remove(s.charAt(left++));
            }
            symbols.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> symbols = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (symbols.containsKey(ch)) {
                left = Math.max(left, symbols.get(ch) + 1);
            }
            symbols.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters task = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(task.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(task.lengthOfLongestSubstring("bbbbb"));
        System.out.println(task.lengthOfLongestSubstring("pwwkew"));
    }
}
