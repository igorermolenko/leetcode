package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }


    public boolean isHappy1(int n) {
        Set<Integer> intermediateSums = new HashSet<>();

        while (intermediateSums.add(n)) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (sum == 1) return true;
            n = sum;
        }
        return false;
    }


    public static void main(String[] args) {
        HappyNumber task = new HappyNumber();
        System.out.println(task.isHappy(19));
        System.out.println(task.isHappy(2));
    }
}
