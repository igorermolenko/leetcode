package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TribonacciNumber {


    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int val = a + b + c;
            a = b;
            b = c;
            c = val;
        }
        return c;
    }



    public static void main(String[] args) {
        TribonacciNumber task = new TribonacciNumber();
        System.out.println(task.tribonacci(4));
        System.out.println(task.tribonacci(25));
    }
}
