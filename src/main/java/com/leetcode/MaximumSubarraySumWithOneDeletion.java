package com.leetcode;

public class MaximumSubarraySumWithOneDeletion {

    // Kadane's algorithm    O(n) time, O(1) space
    public int maximumSum(int[] arr) {
        if (arr.length == 1) return arr[0];

        int maxSumWithDeletion = Integer.MIN_VALUE;
        int maxSumWithoutDeletion = arr[0];

        int currentMaxWithDeletion = 0;
        int currentMaxWithoutDeletion = arr[0];


        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];

            // Choose max with deletion (with deletion on previous step or without a current value)
            currentMaxWithDeletion = Math.max(currentMaxWithDeletion + num, currentMaxWithoutDeletion);
            currentMaxWithoutDeletion = Math.max(num, currentMaxWithoutDeletion + num);

            maxSumWithDeletion = Math.max(maxSumWithDeletion,currentMaxWithDeletion);
            maxSumWithoutDeletion = Math.max(maxSumWithoutDeletion,currentMaxWithoutDeletion);
        }

        return Math.max(maxSumWithoutDeletion, maxSumWithDeletion);
    }


    public static void main(String[] args) {
        MaximumSubarraySumWithOneDeletion task = new MaximumSubarraySumWithOneDeletion();
        System.out.println(task.maximumSum(new int[]{1, -2, 0, 3}));
        System.out.println(task.maximumSum(new int[]{1, -2, -2, 3}));
        System.out.println(task.maximumSum(new int[]{-1, -1, -1, -1}));
    }
}
