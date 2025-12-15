package com.leetcode;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for (int i = 1; i<=n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;
    }


    public static void main(String[] args) {
        CountingBits task = new CountingBits();
        System.out.println(Arrays.toString(task.countBits(2)));
        System.out.println(Arrays.toString(task.countBits(5)));
        System.out.println(Arrays.toString(task.countBits(16)));
    }
}
