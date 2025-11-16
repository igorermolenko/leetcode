package com.leetcode;

public class StringSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sIndex = 0;
        for (char tChar : tChars) {
            if (sChars[sIndex] == tChar) {
                if (++sIndex == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        StringSubsequence subsequence = new StringSubsequence();
        System.out.println(subsequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(subsequence.isSubsequence("axc", "ahbgdc"));
        System.out.println(subsequence.isSubsequence("", "ahbgdc"));
        System.out.println(subsequence.isSubsequence("asd", ""));
    }
}
