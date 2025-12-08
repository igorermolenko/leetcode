package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int currentIdx, int restSum, int restDigits) {
        if (restSum < 0) {
            return;
        }
        if (restDigits == 0) {
            if (restSum == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        for (int i = currentIdx; i <= 9; i++) {
            current.add(i);
            backtrack(result, current, i + 1, restSum - i, restDigits - 1);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSumIII task = new CombinationSumIII();
        System.out.println(task.combinationSum3(3, 7));
        System.out.println(task.combinationSum3(3, 9));
        System.out.println(task.combinationSum3(4, 1));
    }
}
