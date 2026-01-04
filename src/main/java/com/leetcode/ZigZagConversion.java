package com.leetcode;

import java.util.Arrays;

public class ZigZagConversion {

    public String convert2(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder result = new StringBuilder();
        int[][] gaps = new int[numRows][2];
        int fullCycleLength = 2 * numRows - 2;
        gaps[0][0] = gaps[0][1] = gaps[numRows - 1][0] = gaps[numRows - 1][1] = fullCycleLength;
        int gap = 2;
        for (int i = 1; i < numRows - 1; i++) {
            gaps[i][0] = fullCycleLength - gap;
            gaps[i][1] = gap;
            gap += 2;
        }

        for (int i = 0; i < numRows; i++) {
            int pos = i;
            boolean odd = true;
            while (pos < s.length()) {
                result.append(s.charAt(pos));
                pos += gaps[i][odd ? 0 : 1];
                odd = !odd;
            }
        }

        return result.toString();
    }


    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder result = new StringBuilder();
        int cycleLength = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            int gap1, gap2;

            if (i == 0 || i == numRows - 1) {
                gap1 = gap2 = cycleLength;
            } else {
                gap2  = i * 2;
                gap1 = cycleLength - gap2;
            }

            int pos = i;
            boolean useGap1 = true;
            while (pos < s.length()) {
                result.append(s.charAt(pos));
                pos += useGap1 ?  gap1 : gap2;
                useGap1 = !useGap1;
            }
        }

        return result.toString();
    }




    public static void main(String[] args) {
        ZigZagConversion task = new ZigZagConversion();
        System.out.println(task.convert("PAYPALISHIRING", 3));
        System.out.println(task.convert("PAYPALISHIRING", 4));
        System.out.println(task.convert("A", 1));
    }
}
