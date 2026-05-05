package com.leetcode;

public class FindMinimumInRotatedSortedArrayII {


    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == nums[right] && nums[mid] == nums[left]) {
                right--;
            } else if (nums[mid] > nums[right]) {
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

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == nums[right]) {
                if (nums[mid] > nums[left]) {
                    right = mid - 1;
                } else {
                    right--;
                }
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII task = new FindMinimumInRotatedSortedArrayII();
        System.out.println(task.findMin(new int[]{5, 1, 2, 3, 4}));
        System.out.println(task.findMin(new int[]{4, 5, 1, 2, 3}));
        System.out.println(task.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(task.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(task.findMin(new int[]{11, 13, 15, 17}));
        System.out.println(task.findMin(new int[]{1, 3, 5}));
        System.out.println(task.findMin(new int[]{12, 2, 2, 0, 1}));
        System.out.println(task.findMin(new int[]{3, 3, 3, 4, 4, 1, 2, 3, 3}));
        System.out.println(task.findMin(new int[]{1, 3, 3, 3, 3}));
        System.out.println(task.findMin(new int[]{3, 3, 3, 1, 3}));
        System.out.println(task.findMin(new int[]{2, 2, 2, 0, 1}));
    }
}
