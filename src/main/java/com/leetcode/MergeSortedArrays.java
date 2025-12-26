package com.leetcode;

import java.util.Arrays;

public class MergeSortedArrays {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (j >= 0) {
            nums1[k--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
        return nums1;
    }

    public static void main(String[] args) {
        MergeSortedArrays task = new MergeSortedArrays();
        System.out.println(Arrays.toString(task.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
        System.out.println(Arrays.toString(task.merge(new int[]{1}, 1, new int[]{}, 0)));
        System.out.println(Arrays.toString(task.merge(new int[]{0}, 0, new int[]{1}, 1)));
    }
}
