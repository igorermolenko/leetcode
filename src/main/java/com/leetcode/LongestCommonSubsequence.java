package com.leetcode;

public class LongestCommonSubsequence {

    // Solution 1
//    public int longestCommonSubsequence(String text1, String text2) {
//        if (text1.length() == 0 || text2.length() == 0) {
//            return 0;
//        }
//        if (text1.substring(0, 1).equals(text2.substring(0, 1))) {
//            return 1 + longestCommonSubsequence(text1.substring(1), text2.substring(1));
//        }
//        return Math.max(
//                longestCommonSubsequence(text1, text2.substring(1)),
//                longestCommonSubsequence(text1.substring(1), text2)
//        );
//    }


    // Solution 2
//    public int longestCommonSubsequence(String text1, String text2) {
//        return longestCommonSubsequence(text1, text2, 0, 0);
//    }
//
//    public int longestCommonSubsequence(String text1, String text2, int idx1, int idx2) {
//
//        if (text1.length() == idx1 || text2.length() == idx2) {
//            return 0;
//        }
//        if (text1.charAt(idx1) == text2.charAt(idx2)) {
//            return 1 + longestCommonSubsequence(text1, text2, idx1 + 1, idx2 + 1);
//        }
//        return Math.max(
//                longestCommonSubsequence(text1, text2, idx1, idx2 + 1),
//                longestCommonSubsequence(text1, text2, idx1 + 1, idx2)
//        );
//    }


    // Solution 3 (dynamic programming, memoization)
//    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] memo = new int[text1.length()][text2.length()];
//        for (int i = 0; i < text1.length(); i++) {
//            for (int j = 0; j < text2.length(); j++) {
//                memo[i][j] = -1;
//            }
//        }
//        return longestCommonSubsequence(text1, text2, 0, 0, memo);
//    }
//
//    public int longestCommonSubsequence(String text1, String text2, int idx1, int idx2, int[][] memo) {
//        if (text1.length() == idx1 || text2.length() == idx2) {
//            return 0;
//        }
//
//        if (memo[idx1][idx2] == -1) {
//            memo[idx1][idx2] = text1.charAt(idx1) == text2.charAt(idx2) ?
//                    1 + longestCommonSubsequence(text1, text2, idx1 + 1, idx2 + 1, memo) :
//                    Math.max(
//                            longestCommonSubsequence(text1, text2, idx1, idx2 + 1, memo),
//                            longestCommonSubsequence(text1, text2, idx1 + 1, idx2, memo)
//                    );
//        }
//        return memo[idx1][idx2];
//    }


    // Solution 4 (dynamic programming, bottom up)
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length(); i >= 0; i--) {
            for (int j = text2.length(); j >= 0; j--) {
                if (text1.length() == i || text2.length() == j) {
                    memo[i][j] = 0;
                } else {
                    memo[i][j] = text1.charAt(i) == text2.charAt(j) ?
                            1 + memo[i + 1][j + 1] :
                            Math.max(memo[i + 1][j], memo[i][j + 1]);
                }
            }
        }
        return memo[0][0];
    }


    // Solution 4 (dynamic programming, get subsequence itself)
//    public String longestCommonSubsequence(String text1, String text2) {
//        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
//        for (int i = text1.length(); i >= 0; i--) {
//            for (int j = text2.length(); j >= 0; j--) {
//                if (text1.length() == i || text2.length() == j) {
//                    memo[i][j] = 0;
//                } else {
//                    memo[i][j] = text1.charAt(i) == text2.charAt(j) ?
//                            1 + memo[i + 1][j + 1] :
//                            Math.max(memo[i + 1][j], memo[i][j + 1]);
//                }
//            }
//        }
//        int i = 0, j = 0;
//        StringBuffer sequence = new StringBuffer();
//
//        while (i < text1.length() && j < text2.length()) {
//            if (text1.charAt(i) == text2.charAt(j)) {
//                sequence.append(text1.charAt(i));
//                i++;
//                j++;
//            } else {
//                if (memo[i + 1][j] > memo[i][j + 1]) {
//                    i++;
//                } else {
//                    j++;
//                }
//            }
//        }
//
//        return sequence.toString();
//    }





    public static void main(String[] args) {
        LongestCommonSubsequence task = new LongestCommonSubsequence();
        System.out.println(task.longestCommonSubsequence("abcde", "ace"));
        System.out.println(task.longestCommonSubsequence("abc", "abc"));
        System.out.println(task.longestCommonSubsequence("abc", "def"));
        System.out.println(task.longestCommonSubsequence("nematode knowledge", "empty bottle"));
    }
}
