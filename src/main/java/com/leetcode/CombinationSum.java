package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        addCombinations(candidates, target, result, new ArrayList<>(), 0, 0);

        return result;
    }

    private void addCombinations(int[] candidates, int target, List<List<Integer>> result, List<Integer> combination, int currentSum, int startIdx) {
        if (currentSum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (currentSum > target) {
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            currentSum += candidates[i];
            combination.add(candidates[i]);

            addCombinations(candidates, target, result, combination, currentSum, i);

            combination.removeLast();
            currentSum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        CombinationSum task = new CombinationSum();
        System.out.println(task.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(task.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(task.combinationSum(new int[]{2}, 1));
    }
}
