package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {


    // Quickselect Hoar Method    time - O(n) average and O(n²) worst case, space - O(1)
    public int findKthLargest(int[] nums, int k) {
        int targetPos = nums.length - k;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int pivotPos = partitionHoar(nums, left, right);
            if (pivotPos < targetPos) {
                left = pivotPos + 1;
            } else {
                right = pivotPos;
            }
        }

        return nums[left];
    }


    private int partitionHoar(int[] nums, int left, int right) {
        int pivot = nums[left + (right - left) / 2];
        int i = left - 1;
        int j = right + 1;

        while (true) {
            do {
                i++;
            } while (nums[i] < pivot);
            do {
                j--;
            } while (nums[j] > pivot);

            if (i >= j) {
                return j;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


    // Quickselect Lomuto Method   time - O(n) average and O(n²) worst case, space - O(1)
    public int findKthLargest2(int[] nums, int k) {
        int targetPos = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivotPos = partition(nums, left, right);
            if (pivotPos == targetPos) {
                return nums[pivotPos];
            }
            if (pivotPos < targetPos) {
                left = pivotPos + 1;
            } else {
                right = pivotPos - 1;
            }
        }
        return -1;
    }


    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j <= right; j++) {
            if (nums[j] <= pivot) {
                if (i != j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                i++;
            }
        }
        return i - 1;
    }


    // Heap   time - O(n log k), space - O(k)
    public int findKthLargest3(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() == k + 1) {
                heap.poll();
            }
        }

        return heap.poll();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray task = new KthLargestElementInAnArray();
        System.out.println(task.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(task.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
