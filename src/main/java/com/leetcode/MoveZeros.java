package com.leetcode;

import java.util.Arrays;

public class MoveZeros {
    public int[] moveZeroes(int[] nums) {
        int pos = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }
        for (int i = pos; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }


    public static void main(String[] args) {
        MoveZeros zeros = new MoveZeros();
        System.out.println(Arrays.toString(zeros.moveZeroes(new int[]{0, 1, 0, 3, 12})));
        System.out.println(Arrays.toString(zeros.moveZeroes(new int[]{0})));
    }
}
