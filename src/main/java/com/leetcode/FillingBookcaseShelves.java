package com.leetcode;

public class FillingBookcaseShelves {

    //  books[i] = [thickness_i, height_i]
    // O(N^2)
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        dp[0] = 0;

        for (int i = 0; i < books.length; i++) {
            int width = books[i][0];
            int height = books[i][1];
            dp[i + 1] = dp[i] + height;
            for (int j = i - 1; j >= 0; j--) {
                width += books[j][0];
                if (width > shelfWidth) {
                    break;
                }
                height = Math.max(height, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + height);
            }
        }
        return dp[books.length];
    }


    public static void main(String[] args) {
        FillingBookcaseShelves task = new FillingBookcaseShelves();
        System.out.println(task.minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4)); // 6
        System.out.println(task.minHeightShelves(new int[][]{{1, 3}, {2, 4}, {3, 2}}, 6)); // 4
    }
}
