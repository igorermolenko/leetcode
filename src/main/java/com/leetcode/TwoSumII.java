package com.leetcode;

import java.util.Arrays;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            }
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumII task = new TwoSumII();
        System.out.println(Arrays.toString(task.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(task.twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(task.twoSum(new int[]{-1, 0}, -1)));
        System.out.println(Arrays.toString(task.twoSum(new int[]{2, 3, 4, 5, 6, 7, 11, 15}, 9)));
    }
}
