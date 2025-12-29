package com.leetcode;

public class JumpGameII {

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int count = 0;
        int currentEnd = 0;
        int maxJump = 0;

        for (int i = 0; i < nums.length; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (currentEnd == i) {
                count++;
                currentEnd = maxJump;
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        JumpGameII task = new JumpGameII();
        System.out.println(task.jump(new int[]{2, 3, 1}));
        System.out.println(task.jump(new int[]{2, 1}));
        System.out.println(task.jump(new int[]{2, 4, 1, 1, 1}));
        System.out.println(task.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(task.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(task.jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
    }
}
