package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteAndEarn {

    // O(N + M), where N - array length, M - 20000
    public int deleteAndEarn2(int[] nums) {
        int[] sums = new int[20000];
        for (int num: nums) {
            sums[num] += num;
        }
        int prePrevDp = 0, prevDp = 0;

        for (int sum : sums) {
            int curDp = Math.max(prevDp, prePrevDp + sum);
            prePrevDp = prevDp;
            prevDp = curDp;
        }

        return prevDp;
    }

    // With minor optimization by memory and time
    // O(N + M), where N - array length, M - max value of nums
    public int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        for (int num: nums) {
            maxNum = Math.max(maxNum, num);
        }

        int[] sums = new int[maxNum + 1];
        for (int num: nums) {
            sums[num] += num;
        }
        int prePrevDp = 0, prevDp = 0;
        for (int sum: sums) {
            int currDp = Math.max(prevDp, prePrevDp + sum);
            prePrevDp = prevDp;
            prevDp = currDp;
        }

        return prevDp;
    }

    // With optimization. Use Map instead of array
    // But on LeetCode it works dramatically slower
    public int deleteAndEarn3(int[] nums) {
        Map<Integer, Integer> num2sum = new HashMap<>();
        for (int num: nums) {
            num2sum.merge(num, num, Integer::sum);
        }
        List<Integer> orderedNums = new ArrayList<>(num2sum.keySet());
        orderedNums.sort(Integer::compareTo);

        int prePrevDp = 0, prevDp = 0;
        int prevNum = Integer.MIN_VALUE;

        for (int num : orderedNums) {
            if (num != prevNum + 1) {
                // gap → values are independent: f(num-1) == f(num-2) == prevDp
                prePrevDp = prevDp;
            }
            int curDp = Math.max(prevDp, prePrevDp + num2sum.get(num));
            prePrevDp = prevDp;
            prevDp = curDp;
            prevNum = num;
        }

        return prevDp;
    }


    public static void main(String[] args) {
        DeleteAndEarn task = new DeleteAndEarn();
        System.out.println(task.deleteAndEarn(new int[]{3, 4, 2}));  // 6
        System.out.println(task.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));  // 9
    }
}
