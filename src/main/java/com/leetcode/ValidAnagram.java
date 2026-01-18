package com.leetcode;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        for (int ch : chars) {
            if (ch != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram task = new ValidAnagram();
        System.out.println(task.isAnagram("anagram", "nagaram"));
        System.out.println(task.isAnagram("rat", "car"));
    }
}
