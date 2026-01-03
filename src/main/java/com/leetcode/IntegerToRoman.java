package com.leetcode;

public class IntegerToRoman {

    private static final String[] UNITS = new String[]{
            "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] TENS = new String[]{
            "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] HUNDREDS = new String[]{
            "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
    };

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        result.append("M".repeat(num / 1000));
        result.append(HUNDREDS[(num / 100) % 10]);
        result.append(TENS[(num / 10) % 10]);
        result.append(UNITS[num % 10]);

        return result.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman task = new IntegerToRoman();
        System.out.println(task.intToRoman(3749));
        System.out.println(task.intToRoman(58));
        System.out.println(task.intToRoman(1994));
    }
}
