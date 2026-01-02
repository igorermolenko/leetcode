package com.leetcode;

import java.util.Map;

public class RomanToInt {

    private static final Map<Character, Integer> map = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public int romanToInt(String s) {
        char[] romanChars = s.toCharArray();
        int result = 0;

        for (int i = 0; i < romanChars.length; i++) {
            int currentDigit = map.get(romanChars[i]);
            result += currentDigit;
            if (i > 0) {
                int previousDigit = map.get(romanChars[i - 1]);
                if (previousDigit < currentDigit) {
                    result -= previousDigit * 2;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInt task = new RomanToInt();
        System.out.println(task.romanToInt("III"));
        System.out.println(task.romanToInt("LVIII"));
        System.out.println(task.romanToInt("MCMXCIV"));
    }
}
