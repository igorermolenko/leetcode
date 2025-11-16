package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfOccurrences {

    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> occurrences  = new HashMap<>();
        for (int num : arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        Set<Integer> uniqueOccurrences = new HashSet<>(occurrences.values());

        return occurrences.size() == uniqueOccurrences.size();
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences  = new HashMap<>();
        for (int num : arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        Set<Integer> uniqueOccurrences = new HashSet<>();
        for (int occurrence : occurrences.values()) {
            if (!uniqueOccurrences.add(occurrence)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumberOfOccurrences occurrences = new NumberOfOccurrences();
        System.out.println(occurrences.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(occurrences.uniqueOccurrences(new int[]{1,2}));
        System.out.println(occurrences.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
