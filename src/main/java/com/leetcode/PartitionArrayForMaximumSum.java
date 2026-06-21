package com.leetcode;

public class PartitionArrayForMaximumSum {

    // O(N * k)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            int subarrayCount = 1;
            int subarrayMax = arr[i];
            dp[i + 1] = dp[i] + subarrayMax;

            for (int j = i - 1; j >= 0; j--) {
                if (++subarrayCount > k) {
                    break;
                }
                subarrayMax = Math.max(subarrayMax, arr[j]);
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + subarrayCount * subarrayMax);
            }
        }

        return dp[arr.length];
    }


    public static void main(String[] args) {
        PartitionArrayForMaximumSum task = new PartitionArrayForMaximumSum();
        System.out.println(task.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)); // 84
        System.out.println(task.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4)); // 83
        System.out.println(task.maxSumAfterPartitioning(new int[]{1}, 1)); // 1
    }
}
