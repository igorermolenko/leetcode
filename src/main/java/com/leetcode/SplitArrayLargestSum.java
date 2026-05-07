package com.leetcode;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int min = Arrays.stream(nums).max().orElse(Integer.MAX_VALUE);
        int max = Arrays.stream(nums).sum();

        while (min < max) {
            int mid = min + (max - min) / 2;

            int count = countParts(nums, mid);
            if (count <= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return max;
    }

    private int countParts(int[] nums, int sum) {
        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum < num) {
                currentSum = sum;
                count++;
            }
            currentSum -= num;
        }

        return count;
    }


    public static void main(String[] args) {
        SplitArrayLargestSum task = new SplitArrayLargestSum();
        System.out.println(task.splitArray(new int[]{5, 5, 5, 5}, 3));
        System.out.println(task.splitArray(new int[]{1, 4, 4}, 3));
        System.out.println(task.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(task.splitArray(new int[]{1, 2, 3, 4, 5}, 2));
    }
}
