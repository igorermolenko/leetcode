package com.leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp1 = x;
        int temp2 = 0;
        while (temp1 != 0) {
            temp2 = temp2 * 10 + temp1 % 10;
            temp1 = temp1 / 10;
        }

        return temp2 == x;
    }


    public static void main(String[] args) {
        PalindromeNumber task = new PalindromeNumber();
        System.out.println(task.isPalindrome(121));
        System.out.println(task.isPalindrome(-121));
        System.out.println(task.isPalindrome(10));
    }

}
