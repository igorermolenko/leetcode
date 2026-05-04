package com.leetcode;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray task = new FindMinimumInRotatedSortedArray();
        System.out.println(task.findMin(new int[]{5, 1, 2, 3, 4}));
        System.out.println(task.findMin(new int[]{4, 5, 1, 2, 3}));
        System.out.println(task.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(task.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(task.findMin(new int[]{11, 13, 15, 17}));
    }
}
