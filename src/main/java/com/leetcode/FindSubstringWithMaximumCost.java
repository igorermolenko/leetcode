package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindSubstringWithMaximumCost {

    // Kadane's algorithm — O(n) time, O(k) space where k = chars.length()
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> costs = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            costs.put(chars.charAt(i), vals[i]);
        }

        int maxCost = 0;
        int currentMax = 0;

        for (char ch : s.toCharArray()) {
            int charCost = costs.getOrDefault(ch, ch - 'a' + 1);
            currentMax = Math.max(charCost, currentMax + charCost);
            maxCost = Math.max(maxCost, currentMax);
        }

        return maxCost;
    }

    public int maximumCostSubstring2(String s, String chars, int[] vals) {
        int[] costs = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        for (int i = 0; i < chars.length(); i++) {
            costs[chars.charAt(i) - 'a'] = vals[i];
        }

        int maxCost = 0;
        int currentMax = 0;

        for (char ch : s.toCharArray()) {
            int charCost = costs[ch - 'a'];
            currentMax = Math.max(charCost, currentMax + charCost);
            maxCost = Math.max(maxCost, currentMax);
        }

        return maxCost;
    }


    public static void main(String[] args) {
        FindSubstringWithMaximumCost task = new FindSubstringWithMaximumCost();
        System.out.println(task.maximumCostSubstring("adaa", "d", new int[]{-1000}));
        System.out.println(task.maximumCostSubstring("abc", "abc", new int[]{-1, -1, -1}));
    }
}
