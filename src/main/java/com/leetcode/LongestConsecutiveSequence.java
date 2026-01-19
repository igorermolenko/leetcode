package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive2(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.containsKey(num + 1));
            if (map.containsKey(num - 1)) {
                map.put(num - 1, true);
            }
        }
        int maxCounter = 0;
        for (int num : nums) {
            int counter = 0;
            while (map.get(num + counter)) {
                counter++;
            }
            maxCounter = Math.max(maxCounter, counter + 1);
        }

        return maxCounter;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }

        int maxCounter = 0;
        for (int num : uniqueNums) {
            // Count only for num that doesn't have previous num (sequency start)
            if (!uniqueNums.contains(num - 1)) {
                int counter = 1;
                while (uniqueNums.contains(num + counter)) {
                    counter++;
                }
                maxCounter = Math.max(maxCounter, counter);
            }
        }
        return maxCounter;
    }


    public static void main(String[] args) {
        LongestConsecutiveSequence task = new LongestConsecutiveSequence();
        System.out.println(task.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(task.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(task.longestConsecutive(new int[]{1, 0, 1, 2}));
        System.out.println(task.longestConsecutive(new int[]{0}));
        System.out.println(task.longestConsecutive(new int[]{0, 0}));
        System.out.println(task.longestConsecutive(new int[]{}));
    }
}
