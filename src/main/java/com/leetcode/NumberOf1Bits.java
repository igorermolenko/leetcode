package com.leetcode;

public class NumberOf1Bits {
    private static final int MASK = 1; // 000...001

    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (MASK << i)) != 0) {
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        NumberOf1Bits task = new NumberOf1Bits();
        System.out.println(task.hammingWeight(11)); // 3
        System.out.println(task.hammingWeight(128)); // 1
        System.out.println(task.hammingWeight(2147483645)); // 30
    }

}
