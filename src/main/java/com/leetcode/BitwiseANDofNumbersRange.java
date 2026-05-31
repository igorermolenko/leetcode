package com.leetcode;

public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int counter = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            counter++;
        }
        return left << counter;
    }


    public static void main(String[] args) {
        BitwiseANDofNumbersRange task = new BitwiseANDofNumbersRange();
        System.out.println(task.rangeBitwiseAnd(5, 7)); // 4
        System.out.println(task.rangeBitwiseAnd(0, 0)); // 0
        System.out.println(task.rangeBitwiseAnd(1, 2147483647)); // 0
    }

}
