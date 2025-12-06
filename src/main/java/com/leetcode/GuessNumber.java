package com.leetcode;

public class GuessNumber {

    public int guessNumber(int n) {
        int min = 0;
        int max = Integer.MAX_VALUE;

        int current = n;

        while (true) {
            int res = guess(current);
            if (res == 0) {
                return current;
            }
            if (res == 1) {
                min = current;
                current += (max - current) / 2 + 1;
            } else {
                max = current;
                current -= (current - min) / 2;
            }
        }
    }


    private int guess(int num) {
        int pick = 6;
        return Integer.compare(pick, num);
    }



    public static void main(String[] args) {
        GuessNumber task = new GuessNumber();
        System.out.println(task.guessNumber(10));

    }
}
