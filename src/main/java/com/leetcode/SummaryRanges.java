package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                addRange(result, start, nums[i - 1]);
                start = nums[i];
            }
        }
        addRange(result, start, nums[nums.length - 1]);

        return result;
    }

    private void addRange(List<String> result, int start, int end) {
        if (start != end) {
            result.add(start + "->" + end);
        } else {
            result.add(String.valueOf(start));
        }
    }

    public static void main(String[] args) {
        SummaryRanges task = new SummaryRanges();
        System.out.println(task.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(task.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}
