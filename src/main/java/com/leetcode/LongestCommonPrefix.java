package com.leetcode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = getCommonPrefix(prefix, strs[i]);
            if (prefix.isEmpty()) {
                break;
            }
        }

        return  prefix;
    }

    private String getCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, len);
    }



    public static void main(String[] args) {
        LongestCommonPrefix task = new LongestCommonPrefix();
        System.out.println(task.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(task.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
