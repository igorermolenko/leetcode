package com.leetcode;

public class DecodeWays {

    // With minor optimizations (pair calculation and without array)
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;

        int prevPrevDp = 0;
        int prevDp = 1;

        for (int i = 1; i <= chars.length; i++) {
            int curDp = chars[i - 1] != '0' ? prevDp : 0;

            if (i > 1 && (chars[i - 2] == '1' || chars[i - 2] == '2')) {
                int prevPair = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
                if (prevPair <= 26) {
                    curDp += prevPrevDp;
                }
            }

            prevPrevDp = prevDp;
            prevDp = curDp;
        }

        return prevDp;
    }

    public int numDecodings2(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;

        int[] dp = new int[chars.length + 1];
        dp[0] = 1;

        for (int i = 1; i <= chars.length; i++) {
            if (chars[i - 1] != '0') {
                dp[i] = dp[i - 1];
            }
            if (i > 1 && (chars[i - 2] == '1' || chars[i - 2] == '2')) {
                int prevPair = Integer.parseInt(chars[i - 2] + "" + chars[i - 1]);
                if (prevPair <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[chars.length];
    }


    public static void main(String[] args) {
        DecodeWays task = new DecodeWays();
        System.out.println(task.numDecodings("12")); // 2
        System.out.println(task.numDecodings("226")); // 3
        System.out.println(task.numDecodings("06")); // 0
        System.out.println(task.numDecodings("1111")); // 5
    }
}
