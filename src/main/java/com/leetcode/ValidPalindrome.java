package com.leetcode;

import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.toLowerCase;

public class ValidPalindrome {

    public boolean isPalindrome2(String s) {
        String normalizedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = normalizedStr.length() - 1;
        while (i < j) {
            if (normalizedStr.charAt(i++) != normalizedStr.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (toLowerCase(s.charAt(i++)) != toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome task = new ValidPalindrome();
        System.out.println(task.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(task.isPalindrome("race a car"));
        System.out.println(task.isPalindrome(" "));
    }
}
