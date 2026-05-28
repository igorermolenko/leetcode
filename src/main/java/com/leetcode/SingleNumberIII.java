package com.leetcode;

import java.util.Arrays;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int mask = sum & -sum; // Magic formula: Get last 1 bit in number.

        // If you don't remember the formula, use this one
//        int mask = 0;
//        for (int i = 0; i < 32; i++) {
//            if ((sum & (1 << i)) > 0) {
//                mask = (1 << i);
//                break;
//            }
//        }

        int res1 = 0, res2 = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }

        return new int[]{res1, res2};
    }


    public static void main(String[] args) {
        SingleNumberIII task = new SingleNumberIII();
        System.out.println(Arrays.toString(task.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(task.singleNumber(new int[]{-1, 0})));
        System.out.println(Arrays.toString(task.singleNumber(new int[]{0, 1})));
        System.out.println(Arrays.toString(task.singleNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 1, 4, 5, 6, 2})));
    }

}
