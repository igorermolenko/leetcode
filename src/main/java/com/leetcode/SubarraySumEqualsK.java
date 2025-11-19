package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum2Count = new HashMap<>();
        int result = 0;
        int prefixSum = 0;
        prefixSum2Count.put(prefixSum, 1);
        for (int num : nums) {
            prefixSum += num;
            result += prefixSum2Count.getOrDefault(prefixSum - k, 0);
            prefixSum2Count.put(prefixSum, prefixSum2Count.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        SubarraySumEqualsK task = new SubarraySumEqualsK();
        System.out.println(task.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(task.subarraySum(new int[]{1, 2, 3}, 3));
    }
}
