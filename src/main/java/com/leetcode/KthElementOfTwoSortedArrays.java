package com.leetcode;

public class KthElementOfTwoSortedArrays {

    // Binary Search / Divide and Conquer   - O(log(M+N))
    public int findKthElement(int[] arr1, int[] arr2, int k) {
        if (arr1.length > arr2.length) {
            return findKthElement(arr2, arr1, k);
        }

        int left = Math.max(0, k - arr2.length);
        int right = Math.min(arr1.length, k);

        while (left <= right) {
            int pos1 = left + (right - left) / 2;
            int pos2 = k - pos1;

            int l1 = pos1 == 0 ? Integer.MIN_VALUE : arr1[pos1 - 1];
            int l2 = pos2 == 0 ? Integer.MIN_VALUE : arr2[pos2 - 1];
            int r1 = pos1 == arr1.length ? Integer.MAX_VALUE : arr1[pos1];
            int r2 = pos2 == arr2.length ? Integer.MAX_VALUE : arr2[pos2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            if (l1 > r2) {
                right = pos1 - 1;
            } else {
                left = pos1 + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        KthElementOfTwoSortedArrays task = new KthElementOfTwoSortedArrays();
        System.out.println(task.findKthElement(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}, 5)); // 6
        System.out.println(task.findKthElement(new int[]{10, 20, 30, 40}, new int[]{1, 5, 8}, 2)); // 5
        System.out.println(task.findKthElement(new int[]{1, 2}, new int[]{3, 4}, 4)); // 4
        System.out.println(task.findKthElement(new int[]{1, 10, 100}, new int[]{2, 3, 4, 5, 6, 7, 8}, 8)); // 8
        System.out.println(task.findKthElement(new int[]{1, 3, 5}, new int[]{2, 3, 4}, 3)); // 3
    }
}
