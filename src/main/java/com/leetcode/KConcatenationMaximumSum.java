package com.leetcode;

public class KConcatenationMaximumSum {
    private static final int MODULO = 1_000_000_007;


    // Kadane's algorithm    O(n) time, O(1) space
    // Dividing by module for big numbers, for small numbers function below will be enough
    public int kConcatenationMaxSum(int[] arr, int k) {
        long arraySum = 0;
        long maxSum = 0;
        long currentMax = 0;

        for (int num : arr) {
            arraySum += num;
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);
        }

        if (k == 1) {
            return (int) (maxSum % MODULO);
        }

        for (int num : arr) {
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);
        }

        if (arraySum <= 0) {
            return (int) (maxSum % MODULO);
        }

        long addedSum = arraySum * (k - 2);
        return (int) ((maxSum + addedSum) % MODULO);
    }


    // The same as above, but without dividing by modulo for clean understanding
    public int kConcatenationMaxSum2(int[] arr, int k) {
        int arraySum = 0;
        int maxSum = 0;
        int currentMax = 0;

        for (int num : arr) {
            arraySum += num;
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);
        }

        if (k == 1) {
            return maxSum;
        }

        for (int num : arr) {
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);
        }

        if (arraySum <= 0) {
            return maxSum;
        }

        int addedSum = arraySum * (k - 2);

        return maxSum + addedSum;
    }

    public static void main(String[] args) {
        KConcatenationMaximumSum task = new KConcatenationMaximumSum();
//        System.out.println(task.kConcatenationMaxSum(new int[]{1, 2}, 3));
//        System.out.println(task.kConcatenationMaxSum(new int[]{1, -2, 1}, 5));
//        System.out.println(task.kConcatenationMaxSum(new int[]{-1, -2}, 7));
        System.out.println(task.kConcatenationMaxSum(new int[]{10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000}, 100000));
    }
}
