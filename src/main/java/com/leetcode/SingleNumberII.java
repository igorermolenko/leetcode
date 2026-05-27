package com.leetcode;

public class SingleNumberII {
    private static final int MASK = 1; // 000...001

    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }


    public static void main(String[] args) {
        SingleNumberII task = new SingleNumberII();
        System.out.println(task.singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(task.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(task.singleNumber(new int[]{1}));
    }

}
