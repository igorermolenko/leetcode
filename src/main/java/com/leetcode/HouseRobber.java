package com.leetcode;

public class HouseRobber {

    public int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];

        int prePreviousStep= nums[0];
        int previousStep= Math.max(nums[1], prePreviousStep);

        for (int i = 2; i < nums.length; i++) {
            int currentStep = Math.max(nums[i] + prePreviousStep, previousStep);
            prePreviousStep = previousStep;
            previousStep = currentStep;
        }

        return previousStep;
    }


    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp [i -2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }


    public static void main(String[] args) {
        HouseRobber task = new HouseRobber();
        System.out.println(task.rob(new int[]{1, 2, 3, 1}));
        System.out.println(task.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
