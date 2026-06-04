package com.leetcode;

public class Pow {

    public double myPow(double x, int n) {
        double res = 1;
        double currentX = x;
        long pow = n >= 0 ? n : -(long) n;

        while (pow > 0) {
            if ((pow & 1) == 1) {
                res *= currentX;
            }
            currentX *= currentX;
            pow >>>= 1;
        }


        return n >= 0 ? res : 1 / res;
    }

    public static void main(String[] args) {
        Pow task = new Pow();
//        System.out.println(task.myPow(2.0000, 10));    // 1024
//        System.out.println(task.myPow(2.10000, 3));    // 9.26100
//        System.out.println(task.myPow(2.00000, -2));   // 0.25
        System.out.println(task.myPow(2.00000, -2147483648));   // 0.0
    }

}
