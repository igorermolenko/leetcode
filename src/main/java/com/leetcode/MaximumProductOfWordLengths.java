package com.leetcode;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        // Each bit in int is sign of presence char in word (bit 1 - a, bit 2 - b, 2 - c, etc. )
        int[] letters = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                letters[i] |= (1 << (c - 'a'));
            }
        }

        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((letters[i] & letters[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        MaximumProductOfWordLengths task = new MaximumProductOfWordLengths();
        System.out.println(task.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})); // 16
        System.out.println(task.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"})); // 4
        System.out.println(task.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"})); // 0
    }

}
