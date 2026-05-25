package com.leetcode;

public class SingleNumber {
    private static final int MASK = 1; // 000...001

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result ^= num;
        }
        return result;
    }


    public static void main(String[] args) {
        SingleNumber task = new SingleNumber();
        System.out.println(task.singleNumber(new int[]{2, 2, 1}));
        System.out.println(task.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(task.singleNumber(new int[]{1}));
    }

}
