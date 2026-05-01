package com.leetcode;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            int mid = nums[midIdx];
            int left = midIdx > 0 ? nums[midIdx - 1] : Integer.MIN_VALUE;
            int right = midIdx < nums.length - 1 ? nums[midIdx + 1] : Integer.MIN_VALUE;

            if (mid >= left && mid >= right) {
                return midIdx;
            }

            if (mid < left) {
                rightIdx = midIdx - 1;
            } else {
                leftIdx = midIdx + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        FindPeakElement task = new FindPeakElement();
        System.out.println(task.findPeakElement(new int[]{1}));
        System.out.println(task.findPeakElement(new int[]{-2147483648}));
        System.out.println(task.findPeakElement(new int[]{1, 2, 2, 2, 1}));
        System.out.println(task.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(task.findPeakElement(new int[]{1, 2, 3, 4}));
        System.out.println(task.findPeakElement(new int[]{5, 4, 3, 2}));
        System.out.println(task.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(task.findPeakElement(new int[]{1, 2, 3, 4, 5, 4, 3, 2}));
    }
}
