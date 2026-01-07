package com.leetcode;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        ThreeSum task = new ThreeSum();
        System.out.println(task.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(task.threeSum(new int[]{0, 1, 1}));
        System.out.println(task.threeSum(new int[]{0, 0, 0}));
        System.out.println(task.threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(task.threeSum(new int[]{-2, 0, 1, 1, 2}));
    }
}
