package com.leetcode;

public class MergeStringsAlternately {
    public String mergeAlternately2(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int length = Math.min(word1.length(), word2.length());

        for (int i = 0; i < length; i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        if (length < word1.length()) {
            result.append(word1.substring(length));
        } else if (length < word2.length()) {
            result.append(word2.substring(length));
        }

        return result.toString();
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int idx1 = 0, idx2 = 0;
        int length = Math.max(word1.length(), word2.length());

        for(int i = 0; i < length; i++) {
            if (idx1 < word1.length()) result.append(word1.charAt(idx1++));
            if (idx2 < word2.length()) result.append(word2.charAt(idx2++));
        }
        return result.toString();
    }



    public static void main(String[] args) {
        MergeStringsAlternately merger = new MergeStringsAlternately();
        System.out.println(merger.mergeAlternately("abc", "pqt"));
        System.out.println(merger.mergeAlternately("abc", "pq"));
        System.out.println(merger.mergeAlternately("abc", "pqtxyz"));
    }
}
