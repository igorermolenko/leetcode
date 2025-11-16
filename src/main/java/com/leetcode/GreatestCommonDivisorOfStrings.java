package com.leetcode;

public class GreatestCommonDivisorOfStrings {

    public String find2(String str1, String str2) {
        String divisor = str1.length() > str2.length() ? str1 : str2;

        while (divisor.length() > 1) {
            if (str1.replaceAll(divisor, "").isBlank() && str2.replaceAll(divisor, "").isBlank()) {
                return divisor;
            } else {
                divisor = divisor.substring(0, divisor.length() - 1);
            }
        }
        return "";
    }

    public String find(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        int length1 = str1.length();
        int length2 = str2.length();
        int gcd = Math.min(length1, length2);
        while(length1 % gcd != 0 || length2 % gcd != 0) {
            gcd--;
        }
        return str1.substring(0, gcd);
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings gcd = new GreatestCommonDivisorOfStrings();
        System.out.println(gcd.find("ABCABC", "ABC"));
        System.out.println(gcd.find("ABABAB", "ABAB"));
        System.out.println(gcd.find("LEET", "CODE"));
    }
}
