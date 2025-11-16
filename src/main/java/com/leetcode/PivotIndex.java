package com.leetcode;

public class PivotIndex {

    public int pivotIndex2(int[] nums) {
        int[] leftSums = new int[nums.length];
        int[] rightSums = new int[nums.length];
        int leftSum = 0, rightSum = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            leftSums[i] = leftSum;
            rightSums[j] = rightSum;
            leftSum += nums[i];
            rightSum += nums[j];
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSums[i] == rightSums[i]) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }


    public static void main(String[] args) {
        PivotIndex pivot = new PivotIndex();
        System.out.println(pivot.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivot.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(pivot.pivotIndex(new int[]{2, 1, -1}));
    }
}
