package com.leetcode;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int sIdx = 0;
        int tIdx = 0;
        while (sIdx < s.length() && tIdx < t.length()) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
            }
            tIdx++;
        }
        return sIdx == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence task = new IsSubsequence();
        System.out.println(task.isSubsequence("abc", "ahbgdc"));
        System.out.println(task.isSubsequence("axc", "ahbgdc"));
    }
}
