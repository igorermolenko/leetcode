package com.leetcode;

public class IncreasingTriplet {
    public boolean increasingTriplet2(int[] nums) {
        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];
        int min = nums[0];
        int max = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            lefts[i] = min;
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            rights[i] = max;
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = 2; i < nums.length - 1; i++) {
            if (nums[i] > lefts[i] && nums[i] < rights[i]) {
                return true;
            }
        }

        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= first) {
                first = n;
            } else if (n <= second) {
                second = n;
            } else {
                return true; // Found a number greater than both first and second
            }
        }
        return false;
    }



    public static void main(String[] args) {
        IncreasingTriplet triplet = new IncreasingTriplet();
        System.out.println(triplet.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(triplet.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(triplet.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        System.out.println(triplet.increasingTriplet(new int[]{20, 100, 10, 12, 5, 12}));
        System.out.println(triplet.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
        System.out.println(triplet.increasingTriplet(new int[]{1}));
    }
}
