package com.leetcode;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int counter = 0;
        int prevElement = Integer.MIN_VALUE;

        for (int num: nums) {
            if (num != prevElement) {
                nums[counter++] = num;
                prevElement = num;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray task = new RemoveDuplicatesFromSortedArray();
        System.out.println(task.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(task.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
