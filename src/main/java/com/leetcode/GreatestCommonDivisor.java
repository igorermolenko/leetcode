package com.leetcode;

public class GreatestCommonDivisor {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        GreatestCommonDivisor task = new GreatestCommonDivisor();
        System.out.println(task.gcd(4, 12));
        System.out.println(task.gcd(4, -12));
        System.out.println(task.gcd(6, 9));
        System.out.println(task.gcd(10, 125));
        System.out.println(task.gcd(1, 5));
        System.out.println(task.gcd(0, 5));
    }

}
