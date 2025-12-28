package com.leetcode;

import java.util.*;

public class RotateArray {

    public int[] rotate2(int[] nums, int k) {
        Deque<Integer> dequeue = new ArrayDeque<>();

        for (int num: nums) {
            dequeue.offerLast(num);
        }
        for (int i = 0; i < k; i++) {
            dequeue.offerFirst(dequeue.pollLast());
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = dequeue.pollFirst();
        }

        return nums;
    }

    public int[] rotate3(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }

        return nums;
    }

    public int[] rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        return nums;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }

    }

    public static void main(String[] args) {
        RotateArray task = new RotateArray();
        System.out.println(Arrays.toString(task.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(task.rotate(new int[]{- 1, -100, 3, 99}, 2)));
    }
}
