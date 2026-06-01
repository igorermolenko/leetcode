package com.leetcode;

import java.util.Arrays;

public class PlusOne {

    // Early exit
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }


    public int[] plusOne1(int[] digits) {
        int[] result = new int[digits.length + 1];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            result[i + 1] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            result[0] = carry;
        } else {
            result = Arrays.copyOfRange(result, 1, result.length);
        }
        return result;
    }


    public static void main(String[] args) {
        PlusOne task = new PlusOne();
        System.out.println(Arrays.toString(task.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(task.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(task.plusOne(new int[]{9})));
    }

}
