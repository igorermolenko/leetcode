package com.leetcode;

public class AddBinary {


    public String addBinary(String a, String b) {
        int carry = 0;
        int idxA = a.length() - 1;
        int idxB = b.length() - 1;

        StringBuilder res = new StringBuilder();

        while (carry != 0 || idxA >= 0 || idxB >= 0) {
            int digitA = idxA >= 0 && a.charAt(idxA--) == '1' ? 1 : 0;
            int digitB = idxB >= 0 && b.charAt(idxB--) == '1' ? 1 : 0;
            int sum = digitA + digitB + carry;

            res.append((sum % 2));
            carry = sum / 2;
        }

        return res.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        int length = Math.max(a.length(), b.length());
        int diffA = length - a.length();
        int diffB = length - b.length();

        int carry = 0;
        StringBuilder res = new StringBuilder();

        for (int i = length - 1; i >= 0; i--) {
            int idxA = i - diffA;
            int idxB = i - diffB;
            int digitA = idxA >= 0 && a.charAt(idxA) == '1' ? 1 : 0;
            int digitB = idxB >= 0 && b.charAt(idxB) == '1' ? 1 : 0;
            int sum = digitA + digitB + carry;

            res.append((sum % 2));
            carry = sum / 2;
        }

        if (carry > 0) {
            res.append(carry);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary task = new AddBinary();
        System.out.println(task.addBinary("11", "1"));
        System.out.println(task.addBinary("1010", "1011"));
    }

}
