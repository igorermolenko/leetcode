package com.leetcode;

public class LargestSumOfAverages {

    // Better to divide onto k groups.
    // Because dividing to bigger amount of group is always bigger or at least the same as lower amount of groups.
    // So need to divide onto k groups despite statement «at most k non-empty adjacent subarrays»

    //  O(K * N^2)
    public double largestSumOfAverages2(int[] nums, int k) {
        double[] previousDp = new double[nums.length + 1];

        int curSum = 0;
        for (int i = 1; i <= nums.length; i++) {
            curSum += nums[i - 1];
            previousDp[i] = (double) curSum / i;
        }


        for (int groupsCount = 2; groupsCount <= k; groupsCount++) {
            double[] currentDp = new double[nums.length + 1];
            for (int i = groupsCount; i <= nums.length; i++) {
                int curCount = 0;
                curSum = 0;

                for (int j = i; j > groupsCount - 1; j--) {
                    curCount++;
                    curSum += nums[j - 1];
                    currentDp[i] = Math.max(currentDp[i], previousDp[j - 1] + (double) curSum / curCount);
                }
            }
            previousDp = currentDp;
        }

        return previousDp[nums.length];
    }


    //  O(K * N)
    // A little bit optimized. Instead of calculation sum on fly, precalculated prefix sums.
    public double largestSumOfAverages(int[] nums, int k) {
        double[] previousDp = new double[nums.length + 1];
        int[] prefixes = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            prefixes[i] = prefixes[i - 1] + nums[i - 1];
            previousDp[i] = (double) prefixes[i] / i;
        }

        for (int groupCount = 2; groupCount <= k; groupCount++) {
            double[] currentDp = new double[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                for (int j = groupCount - 1; j < i; j++) {
                    double curAverage = (double)(prefixes[i] - prefixes[j]) / (i - j);
                    currentDp[i] = Math.max(currentDp[i], previousDp[j] + curAverage);
                }
            }
            previousDp = currentDp;
        }

        return previousDp[nums.length];
    }


    public static void main(String[] args) {
        LargestSumOfAverages task = new LargestSumOfAverages();
        System.out.println(task.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3)); // 20.0
        System.out.println(task.largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4)); // 20.5
    }
}
