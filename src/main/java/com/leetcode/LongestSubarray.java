package com.leetcode;

public class LongestSubarray {

    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, maxCount = 0, zeroCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            right++;
            maxCount = Math.max(maxCount, right - left - 1);
        }
        return maxCount;
    }


    public static void main(String[] args) {
        LongestSubarray sub = new LongestSubarray();
        System.out.println(sub.longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(sub.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(sub.longestSubarray(new int[]{1, 1, 1}));
    }
}
