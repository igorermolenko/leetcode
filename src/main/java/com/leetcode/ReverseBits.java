package com.leetcode;

public class ReverseBits {
    private static final int MASK = 1; // 000...001

    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int lastBit = (n >>> i) & MASK;
            result <<= 1;
            result |= lastBit;
        }

        return result;
    }


    public static void main(String[] args) {
        ReverseBits task = new ReverseBits();
        System.out.println(task.reverseBits(43261596)); // 964176192
        System.out.println(task.reverseBits(2147483644)); // 1073741822
    }

}
