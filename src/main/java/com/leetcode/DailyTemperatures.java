package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures2(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int counter = 0;
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                result[stack.pop()] += ++counter;
            }
            for (int idx : stack) {
                result[idx] += counter;
            }
            stack.push(i);
        }
        for (int idx : stack) {
            result[idx] = 0;
        }
        return  result;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }
        return  result;
    }


    public static void main(String[] args) {
        DailyTemperatures task = new DailyTemperatures();
        System.out.println(Arrays.toString(task.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(task.dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(task.dailyTemperatures(new int[]{30, 60, 90})));
        System.out.println(Arrays.toString(task.dailyTemperatures(new int[]{55,38,53,81,61,93,97,32,43,78})));
    }
}
