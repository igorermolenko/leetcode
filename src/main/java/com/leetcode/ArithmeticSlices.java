package com.leetcode;

public class ArithmeticSlices {

    // O(n) - time, O(n) - memory
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;

        for (int i = 2; i < nums.length; i++) {
            dp[i] = (nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2]) ? dp[i] = dp[i - 1] + 1 : 0;
            result += dp[i];
        }

        return result;
    }

    // The same as above but with constant memory
    // O(n) - time, O(1) - memory
    public int numberOfArithmeticSlices2(int[] nums) {
        int dp = 0;
        int result = 0;

        for (int i = 2; i < nums.length; i++) {
            dp = (nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2]) ? dp + 1 : 0;
            result += dp;
        }

        return result;
    }


    public static void main(String[] args) {
        ArithmeticSlices task = new ArithmeticSlices();
        System.out.println(task.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));  // 3
        System.out.println(task.numberOfArithmeticSlices(new int[]{1}));  // 0
    }
}
