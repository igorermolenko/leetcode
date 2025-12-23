package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        return result;
    }


    public static void main(String[] args) {
        NextGreaterElement task = new NextGreaterElement();
        System.out.println(Arrays.toString(task.nextGreaterElement(new int[]{3, 1, 4, 2}, new int[]{3, 1, 4, 2})));
        System.out.println(Arrays.toString(task.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(task.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }
}
