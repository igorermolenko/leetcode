package com.leetcode;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int firstIdx = -1;
        int lastIdx = -1;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid] || (mid > 0 && target == nums[mid - 1])) {
                right = mid - 1;
            } else {
                firstIdx = mid;
                lastIdx = mid;
                left = mid + 1;
                break;
            }
        }

        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid] || (mid < nums.length - 1 && target == nums[mid + 1])) {
                left = mid + 1;
            } else {
                lastIdx = mid;
                break;
            }
        }

        return new int[] {firstIdx, lastIdx};
    }


    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int midTargetIdx = -1;
        int firstTargetIdx = -1;
        int lastTargetIdx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                midTargetIdx = mid;
                break;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (midTargetIdx != -1) {
            left = 0;
            right = midTargetIdx;

            while (left <= right) {
                firstTargetIdx = left + (right - left) / 2;
                if (target != nums[firstTargetIdx]) {
                    left = firstTargetIdx + 1;
                } else if (firstTargetIdx > 0 && target == nums[firstTargetIdx - 1]) {
                    right = firstTargetIdx - 1;
                } else {
                    break;
                }
            }

            left = midTargetIdx;
            right = nums.length - 1;

            while (left <= right) {
                lastTargetIdx = left + (right - left) / 2;
                if (target != nums[lastTargetIdx]) {
                    right = lastTargetIdx - 1;
                } else if (lastTargetIdx < nums.length - 1 && target == nums[lastTargetIdx + 1]) {
                    left = lastTargetIdx + 1;
                } else {
                    break;
                }
            }
        }

        return new int[] {firstTargetIdx, lastTargetIdx};
    }

    public static void main(String[] args) {
        FirstAndLastPositionOfElementInSortedArray task = new FirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(task.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(task.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(task.searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(task.searchRange(new int[]{1}, 1)));
    }
}
