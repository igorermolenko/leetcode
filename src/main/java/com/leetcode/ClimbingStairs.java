package com.leetcode;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 1) return n;

        int prevPrev = 1, prev = 2;
        for (int i = 0; i < n - 2; i++) {
            int curr = prevPrev + prev;
            prevPrev = prev;
            prev = curr;
        }
        return prev;
    }

    public int climbStairs2(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {
        ClimbingStairs task = new ClimbingStairs();
        System.out.println(task.climbStairs(2));
        System.out.println(task.climbStairs(3));
    }
}
