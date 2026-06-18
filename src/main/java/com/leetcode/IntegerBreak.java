package com.leetcode;

public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        IntegerBreak task = new IntegerBreak();
        System.out.println(task.integerBreak(2));  // 1
        System.out.println(task.integerBreak(10));  // 36
    }
}
