package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> windowFrequency = new HashMap<>();
        Map<Character, Integer> targetFrequency = new HashMap<>();
        for (char ch : t.toCharArray()) {
            targetFrequency.put(ch, targetFrequency.getOrDefault(ch, 0) + 1);
        }
        int targetSymbolsCount = targetFrequency.size();
        int windowSymbolsCount = 0;

        int left = 0;
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char rightCh = s.charAt(right);
            windowFrequency.put(rightCh, windowFrequency.getOrDefault(rightCh, 0) + 1);

            if (targetFrequency.containsKey(rightCh) && windowFrequency.get(rightCh).equals(targetFrequency.get(rightCh))) {
                windowSymbolsCount++;
            }

            while (windowSymbolsCount == targetSymbolsCount && left <= right) {
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                char leftCh = s.charAt(left);
                windowFrequency.put(leftCh, windowFrequency.get(leftCh) - 1);
                if (targetFrequency.containsKey(leftCh) && windowFrequency.get(leftCh) < targetFrequency.get(leftCh)) {
                    windowSymbolsCount--;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }


    public static void main(String[] args) {
        MinimumWindowSubstring task = new MinimumWindowSubstring();
        System.out.println(task.minWindow("ADOBECODEBANC", "AABC"));
        System.out.println(task.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(task.minWindow("a", "a"));
        System.out.println(task.minWindow("a", "aa"));
    }
}
