package com.leetcode;

import java.util.HashMap;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> sums2pos = new HashMap<>() {{
            put(0, -1);
        }};

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i] == 0 ? -1 : 1;
            if (sums2pos.containsKey(currentSum)) {
                maxLength = Math.max(maxLength, i - sums2pos.get(currentSum));
            } else {
                sums2pos.put(currentSum, i);
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        ContiguousArray task = new ContiguousArray();
        System.out.println(task.findMaxLength(new int[]{0, 1}));
        System.out.println(task.findMaxLength(new int[]{0, 1, 0}));
        System.out.println(task.findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0}));
    }
}
