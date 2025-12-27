package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxCount = 0;
        int majority = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                majority = entry.getKey();
            }
        }
        return majority;
    }

    public int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                majorityElement = num;
                count = 1;
            } else if (num == majorityElement) {
                count++;
            } else {
                count--;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        MajorityElement task = new MajorityElement();
        System.out.println(task.majorityElement(new int[]{3, 2, 3}));
        System.out.println(task.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
