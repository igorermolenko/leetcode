package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.remove(nums[i])) {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }


    public static void main(String[] args) {
        SingleNumber task = new SingleNumber();
        System.out.println(task.singleNumber(new int[]{2, 2, 1}));
        System.out.println(task.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(task.singleNumber(new int[]{1}));
    }
}
