package com.leetcode;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int counter = 2;

        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            if (num != nums[counter - 1] || num != nums[counter - 2]) {
                nums[counter++] = num;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII task = new RemoveDuplicatesFromSortedArrayII();
        System.out.println(task.removeDuplicates(new int[]{1, 2}));
        System.out.println(task.removeDuplicates(new int[]{1, 2, 2}));
        System.out.println(task.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(task.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
