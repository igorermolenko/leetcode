package com.leetcode;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {

    // O(NlogN)
    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs,  (a, b) -> a.endTime - b.endTime);

        int[] dp = new int[jobs.length];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < jobs.length; i++) {
            dp[i] = Math.max(dp[i - 1], jobs[i].profit + getPreviousProfit(jobs, dp, i));
        }

        return dp[jobs.length - 1];
    }

    private int getPreviousProfit(Job[] jobs, int[] dp, int currentIdx) {
        int left = 0;
        int right = currentIdx - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid].endTime > jobs[currentIdx].startTime) {
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
        }

        return right >= 0 && jobs[right].endTime <= jobs[currentIdx].startTime ? dp[right] : 0;
    }

    private record Job(int startTime, int endTime, int profit) {
    }



    // ====================================================================================
    // O(NlogN), with minor optimization (do not use additional objects, used array instead)
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs,  (a, b) -> a[1] - b[1]);

        int[] dp = new int[jobs.length];
        dp[0] = jobs[0][2];

        for (int i = 1; i < jobs.length; i++) {
            dp[i] = Math.max(dp[i - 1], jobs[i][2] + getPreviousProfit2(jobs, dp, i));
        }

        return dp[jobs.length - 1];
    }

    private int getPreviousProfit2(int[][] jobs, int[] dp, int currentIdx) {
        int left = 0;
        int right = currentIdx - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > jobs[currentIdx][0]) {
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
        }

        return right >= 0 && jobs[right][1] <= jobs[currentIdx][0] ? dp[right] : 0;
    }


    public static void main(String[] args) {
        MaximumProfitInJobScheduling task = new MaximumProfitInJobScheduling();
        System.out.println(task.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));  // 120
        System.out.println(task.jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));  // 150
        System.out.println(task.jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}));  // 6
    }
}
