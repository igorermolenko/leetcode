package com.leetcode;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n < 3) return n;

        int prePreviousStair = 1;
        int previousStair = 2;
        for (int i = 3; i <= n; i++) {
            int currentStair = prePreviousStair + previousStair;
            prePreviousStair = previousStair;
            previousStair = currentStair;
        }

        return previousStair;
    }


    public static void main(String[] args) {
        ClimbingStairs task = new ClimbingStairs();
        System.out.println(task.climbStairs(2));
        System.out.println(task.climbStairs(3));
    }
}
