package com.leetcode;

public class DominoAndTromino {


    public int numTilings1(int n) {
        if (n < 2) {
            return 1;
        }

        int MOD = 1_000_000_007;

        long[] base = new long[n + 1];
        long[] extra = new long[n + 1];

        base[0] = 1;
        base[1] = 1;

        extra[0] = 0;
        extra[1] = 1;

        for (int i = 2; i <= n; i++) {
            extra[i] = (extra[i - 1] + base[i - 1]) % MOD;
            base[i] = (base[i - 1] + base[i - 2] + 2 * extra[i - 2]) % MOD;
        }

        return (int) base[n];
    }


    public int numTilings(int n) {
        if (n < 2) {
            return 1;
        }

        int MOD = 1_000_000_007;

        long prevBase = 1;
        long curBase = 1;

        long prevExtra = 0;
        long curExtra = 1;

        for (int i = 2; i <= n; i++) {
            long newExtra = (curExtra + curBase) % MOD;
            long newBase = (curBase + prevBase + 2L * prevExtra) % MOD;

            prevExtra = curExtra;
            prevBase = curBase;
            curExtra = newExtra;
            curBase = newBase;
        }

        return (int) curBase;
    }


    public static void main(String[] args) {
        DominoAndTromino task = new DominoAndTromino();
        System.out.println(task.numTilings(30));
        System.out.println(task.numTilings(3));
        System.out.println(task.numTilings(1));
    }
}
