package com.leetcode;

public class MinCostClimbingStairs {


    public int minCostClimbingStairs(int[] cost) {
        int prePreviousStair = cost[0];
        int previousStair = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int currentStair = Math.min(prePreviousStair, previousStair) + cost[i];
            prePreviousStair = previousStair;
            previousStair = currentStair;
        }
        return Math.min(prePreviousStair, previousStair);
    }


    public static void main(String[] args) {
        MinCostClimbingStairs task = new MinCostClimbingStairs();
        System.out.println(task.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(task.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
