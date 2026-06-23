package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    // backtracking
    // O (n ^ target / min(candidates))
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


    // =================================================================================
    // Solution using DP
    // Less effective due Lists allocation, but complexity better than for backtracking
    // O(n⋅target⋅k)
    public List<List<Integer>> combinationSumDp(int[] candidates, int target) {
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());

        for (int candidate : candidates) {
            for (int i = candidate; i <= target; i++) {
                List<List<Integer>> combinations = dp[i - candidate];
                if (combinations != null) {
                    if (dp[i] == null) {
                        dp[i] = new ArrayList<>();
                    }
                    for (List<Integer> combination : combinations) {
                        List<Integer> newCombination = new ArrayList<>(combination);
                        newCombination.add(candidate);
                        dp[i].add(newCombination);
                    }
                }
            }
        }

        return dp[target] == null ? new ArrayList<>() : dp[target];
    }


    public static void main(String[] args) {
        CombinationSum task = new CombinationSum();
        System.out.println(task.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(task.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(task.combinationSum(new int[]{2}, 1));

        System.out.println("============================");

        System.out.println(task.combinationSumDp(new int[]{2, 3, 6, 7}, 7));
        System.out.println(task.combinationSumDp(new int[]{2, 3, 5}, 8));
        System.out.println(task.combinationSumDp(new int[]{2}, 1));
    }
}
