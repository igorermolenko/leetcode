package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveOnes {

    public int longestOnes1(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int maxCount = 0;
        int flippersCount = k;
        Set<Integer> flipped = new HashSet<>();
        while (j < nums.length) {
            if (nums[j] == 1) {
                j++;
            } else if (flippersCount > 0)  {
                flipped.add(j);
                flippersCount--;
                j++;
            } else {
                maxCount = Math.max(maxCount, (j - i));
                if (flipped.remove(i)) {
                    flippersCount++;
                }
                i++;
                if (j < i) {
                    j = i;
                }
            }
        }
        return Math.max(maxCount, (j - i));
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            right++;
            maxCount = Math.max(maxCount, right - left);
        }

        return maxCount;
    }



    public static void main(String[] args) {
        ConsecutiveOnes ones = new ConsecutiveOnes();
        System.out.println(ones.longestOnes(new int[] {0,0,0,1}, 4));
        System.out.println(ones.longestOnes(new int[] {0,0,1,1,1,0,0}, 0));
        System.out.println(ones.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(ones.longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
