package com.leetcode;

public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x / mid >= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        Sqrt task = new Sqrt();
        System.out.println(task.mySqrt(0));    // 0
        System.out.println(task.mySqrt(1));    // 1
        System.out.println(task.mySqrt(4));    // 2
        System.out.println(task.mySqrt(8));    // 2
        System.out.println(task.mySqrt(15));    // 3
        System.out.println(task.mySqrt(16));    // 4
    }

}
