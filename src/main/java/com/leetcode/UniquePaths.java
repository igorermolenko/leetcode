package com.leetcode;

public class UniquePaths {


    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
             }
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths(int m, int n) {
        int[] previousRow = new int[n];
        int[] currentRow = new int[n];
        for (int j = 0; j < n; j++) {
            previousRow[j] = 1;
            currentRow[j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                currentRow[j] = currentRow[j-1] + previousRow[j];
            }
            previousRow = currentRow;
        }
        return currentRow[n-1];
    }



    public static void main(String[] args) {
        UniquePaths task = new UniquePaths();
        System.out.println(task.uniquePaths(3, 7));
        System.out.println(task.uniquePaths(3, 2));
        System.out.println(task.uniquePaths(1, 1));
        System.out.println(task.uniquePaths(1, 2));
    }
}
