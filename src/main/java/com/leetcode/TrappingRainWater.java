package com.leetcode;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;  // Need at least 3 bars to trap water
        }

        int volume = 0;
        int leftMax = 0, rightMax = 0;
        int leftIdx = 0, rightIdx = height.length - 1;

        while (leftIdx < rightIdx) {
            if (height[leftIdx] < height[rightIdx]) {
                if (height[leftIdx] >= leftMax) {
                    leftMax = height[leftIdx];
                } else {
                    volume += leftMax - height[leftIdx];
                }
                leftIdx++;
            } else {
                if (height[rightIdx] >= rightMax) {
                    rightMax = height[rightIdx];
                }  else {
                    volume += rightMax - height[rightIdx];
                }
                rightIdx--;
            }
        }

        return volume;
    }


    public static void main(String[] args) {
        TrappingRainWater task = new TrappingRainWater();
        System.out.println(task.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(task.trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(task.trap(new int[]{4, 2, 2, 4}));
        System.out.println(task.trap(new int[]{4, 2, 4, 2}));
        System.out.println(task.trap(new int[]{2, 4, 2, 4}));
        System.out.println(task.trap(new int[]{2, 4, 4, 2}));
    }
}
