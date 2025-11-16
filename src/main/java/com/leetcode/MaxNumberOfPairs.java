package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfPairs {

    public int maxOperations2(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int operationsCount = 0;
        for(int number1 : countMap.keySet()) {
            int number2 = k - number1;
            if (number1 == number2) {
                operationsCount +=  countMap.get(number1) / 2;
            } else {
                operationsCount += Math.min(countMap.getOrDefault(number1, 0), countMap.getOrDefault(number2, 0));
            }
            countMap.put(number1, 0);
        }
        return operationsCount;
    }

    public int maxOperations3(int[] nums, int k) {
        int operationsCount = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num1 : nums) {
            int num2 = k - num1;
            countMap.put(num1, countMap.getOrDefault(num1, 0) + 1);
            if (num1 == num2) {
                if (countMap.get(num1) == 2) {
                    countMap.put(num1, 0);
                    operationsCount++;
                }
            } else if (countMap.getOrDefault(num2, 0) > 0) {
                countMap.put(num1, countMap.get(num1) - 1);
                countMap.put(num2, countMap.get(num2) - 1);
                operationsCount++;
            }

        }
        return operationsCount;
    }

    public int maxOperations(int[] nums, int k) {
        int operationsCount = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num1 : nums) {
            int num2 = k - num1;
            if (num1 == num2) {
                if (countMap.getOrDefault(num1, 0) > 0) {
                    countMap.remove(num1);
                    operationsCount++;
                } else {
                    countMap.put(num1, 1);
                }
            } else if (countMap.getOrDefault(num2, 0) > 0) {
                countMap.put(num2, countMap.get(num2) - 1);
                operationsCount++;
            } else {
                countMap.put(num1, countMap.getOrDefault(num1, 0) + 1);
            }
        }
        return operationsCount;
    }

    public static void main(String[] args) {
        MaxNumberOfPairs pairs = new MaxNumberOfPairs();
        System.out.println(pairs.maxOperations(new int[] {1,2,3,4}, 5));
        System.out.println(pairs.maxOperations(new int[] {3,1,3,4,3}, 6));
        System.out.println(pairs.maxOperations(new int[] {2,2,2,3,1,1,4,1}, 4));
        System.out.println(pairs.maxOperations(new int[] {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3));
    }
}
