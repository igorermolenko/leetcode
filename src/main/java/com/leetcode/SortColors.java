package com.leetcode;

import java.util.Arrays;

public class SortColors {


    // Quicksort Lomuto Method   time - O(n) average and O(n²) worst case, space - O(1)
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left++, mid++);
            } else if (nums[mid] == 2) {
                swap(nums, right--, mid);
            } else {
                mid++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        SortColors task = new SortColors();
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        task.sortColors(nums1);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {2, 0, 1};
        task.sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {1, 2, 0};
        task.sortColors(nums3);
        System.out.println(Arrays.toString(nums3));
    }

}
