package com.leetcode;

import java.util.Arrays;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            n /= 5;
            res += n;
        }
        return res;
    }

    // The same approach but slightly differs. We don't change n, but each time we multiply divider by 5 (5, 25, 125, 625, etc.)
    public int trailingZeroes2(int n) {
        int res = 0;
        int powerOf5 = 5;
        while (powerOf5 <= n) {
            res += n / powerOf5 ;
            powerOf5 *= 5;
        }
        return res;
    }


    public static void main(String[] args) {
        FactorialTrailingZeroes task = new FactorialTrailingZeroes();
        System.out.println(task.trailingZeroes(3));    // 0
        System.out.println(task.trailingZeroes(5));    // 1
        System.out.println(task.trailingZeroes(0));    // 0
        System.out.println(task.trailingZeroes(1000)); // 249
        System.out.println(task.trailingZeroes(4617)); // 1151
    }

}
