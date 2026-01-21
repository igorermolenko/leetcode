package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        TwoSum task = new TwoSum();
        System.out.println(Arrays.toString(task.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(task.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(task.twoSum(new int[]{3, 3}, 6)));
    }
}
