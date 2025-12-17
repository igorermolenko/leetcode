package com.leetcode;

public class MinimumFlipsToMakeAOrBEqualsC {

    public int minFlips(int a, int b, int c) {
        int counter = 0;
        while (a != 0 || b != 0 || c != 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if (bitA == 0 && bitB == 0 && bitC == 1) {
                counter++;
            }
            if (bitC == 0) {
                if (bitA == 1) {
                    counter++;
                }
                if (bitB == 1) {
                    counter++;
                }
            }

            a>>= 1;
            b>>= 1;
            c>>= 1;
        }
        return counter;
    }


    public static void main(String[] args) {
        MinimumFlipsToMakeAOrBEqualsC task = new MinimumFlipsToMakeAOrBEqualsC();
        System.out.println(task.minFlips(2, 6, 5));
        System.out.println(task.minFlips(4, 2, 7));
        System.out.println(task.minFlips(1, 2, 3));
    }
}
