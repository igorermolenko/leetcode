package com.leetcode;

public class PeakElement {

    public int findPeakElement(int[] nums) {
        int leftBound = 0;
        int rightBound = nums.length;

        while (leftBound < rightBound) {
            int midIdx = leftBound + (rightBound - leftBound) / 2;

            int mid = nums[midIdx];
            long left = midIdx > 0 ? nums[midIdx - 1] : Long.MIN_VALUE;
            long right = midIdx < nums.length - 1 ? nums[midIdx + 1] : Long.MIN_VALUE;

            if (mid > left && mid > right) {
                return midIdx;
            }
            if (mid < left) {
                rightBound = midIdx;
            } else {
                leftBound = midIdx;
            }

        }
        return -1;
    }



    public static void main(String[] args) {
        PeakElement task = new PeakElement();
        System.out.println(task.findPeakElement(new int[]{1}));
        System.out.println(task.findPeakElement(new int[]{-2147483648}));
        System.out.println(task.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(task.findPeakElement(new int[]{1, 2, 3, 4}));
        System.out.println(task.findPeakElement(new int[]{5, 4, 3, 2}));
        System.out.println(task.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(task.findPeakElement(new int[]{1, 2, 3, 4, 5, 4, 3, 2}));
    }
}
