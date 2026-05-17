package com.leetcode;

import java.util.Arrays;
import java.util.Random;

public class SortAnArray {
    private static final Random RND = new Random();

    // Quicksort Hoar Method   time - O(n*log(n))
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIdx = partition(nums, left, right);
            sort(nums, left, pivotIdx);
            sort(nums, pivotIdx + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivotIdx = left + RND.nextInt(right - left + 1);
        int pivot = nums[pivotIdx];
        int i = left - 1;
        int j = right + 1;

        while (true) {
            do { i++; } while(nums[i] < pivot);
            do { j--; } while(nums[j] > pivot);

            if (i >= j) {
                return j;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


    public static void main(String[] args) {
        SortAnArray task = new SortAnArray();
        System.out.println(Arrays.toString(task.sortArray(new int[]{5, 2, 3})));
        System.out.println(Arrays.toString(task.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(task.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
        System.out.println(Arrays.toString(task.sortArray(new int[]{-2, 3, -5})));
    }

}
