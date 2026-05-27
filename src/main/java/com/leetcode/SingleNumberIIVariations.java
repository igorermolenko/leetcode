package com.leetcode;

public class SingleNumberIIVariations {

    public int singleNumber3(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            int nextOnes = ones ^ num;
            int nextTwos = twos ^ (num & ones);

            // 11 - 3
            int resetMask = nextTwos & nextOnes;

            ones = nextOnes & ~resetMask;
            twos = nextTwos & ~resetMask;
        }

        return ones;
    }

    public int singleNumber4(int[] nums) {
        int ones = 0, twos = 0, threes = 0;

        for (int num : nums) {
            int nextOnes = ones ^ num;
            int nextTwos = twos ^ (num & ones);
            int nextThrees = threes ^ (num & ones & twos);

            // 100 - 4
            int resetMask = nextThrees & ~nextTwos & ~nextOnes;

            ones = nextOnes & ~resetMask;
            twos = nextTwos & ~resetMask;
            threes = nextThrees & ~resetMask;
        }

        return ones;
    }

    public int singleNumber9(int[] nums) {
        int ones = 0, twos = 0, threes = 0, fours = 0;

        for (int num : nums) {
            int nextOnes = ones ^ num;
            int nextTwos = twos ^ (num & ones);
            int nextThrees = threes ^ (num & ones & twos);
            int nextFours = fours ^ (num & ones & twos & threes);

            // 1001 - 9
            int resetMask = nextFours & ~nextThrees & ~nextTwos & nextOnes;

            ones = nextOnes & ~resetMask;
            twos = nextTwos & ~resetMask;
            threes = nextThrees & ~resetMask;
            fours = nextFours & ~resetMask;
        }

        return ones;
    }


    public static void main(String[] args) {
        SingleNumberIIVariations task = new SingleNumberIIVariations();
        System.out.println(task.singleNumber3(new int[]{2, 2, 3, 2}));
        System.out.println(task.singleNumber3(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(task.singleNumber3(new int[]{1}));
        System.out.println("-----------");
        System.out.println(task.singleNumber4(new int[]{2, 2, 3, 2, 2}));
        System.out.println(task.singleNumber4(new int[]{0, 1, 0, 1, 0, 1, 99, 0, 1}));
        System.out.println(task.singleNumber4(new int[]{1}));
        System.out.println("-----------");
        System.out.println(task.singleNumber9(new int[]{2, 2, 3, 2, 2, 2, 2, 2, 2, 2}));
        System.out.println(task.singleNumber9(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 99, 0, 1, 0, 1, 0, 1, 0, 1}));
        System.out.println(task.singleNumber9(new int[]{1}));
    }

}
