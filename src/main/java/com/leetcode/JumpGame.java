package com.leetcode;

public class JumpGame {

    public boolean canJump2(int[] nums) {
        int minStepsToJumpOver = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (minStepsToJumpOver > 0) {
                if (nums[i] > minStepsToJumpOver) {
                    minStepsToJumpOver = 0;
                } else  {
                    minStepsToJumpOver++;
                }
            } else if (nums[i] == 0) {
                minStepsToJumpOver = 1;
            }
        }
        return minStepsToJumpOver == 0;
    }


    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxReach >= i) {
                maxReach = Math.max(maxReach, i + nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame task = new JumpGame();
        System.out.println(task.canJump(new int[]{0}));
        System.out.println(task.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(task.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(task.canJump(new int[]{3, 2, 0, 1, 0, 1}));
    }
}
