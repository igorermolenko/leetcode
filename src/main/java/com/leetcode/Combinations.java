package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        addCombinations(1, n, k, result, new ArrayList<>());
        return result;
    }

    private void addCombinations2(int start, int end, int count, List<List<Integer>> result, List<Integer> combination) {
        if (combination.size() == count) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= end; i++) {
            combination.add(i);
            addCombinations2(i + 1, end, count, result, combination);
            combination.removeLast();
        }
    }

    private void addCombinations(int start, int end, int count, List<List<Integer>> result, List<Integer> combination) {
        if (count == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= end - count + 1; i++) {
            combination.add(i);
            addCombinations(i + 1, end, count - 1, result, combination);
            combination.removeLast();
        }
    }


    public static void main(String[] args) {
        Combinations task = new Combinations();
        System.out.println(task.combine(4, 2));
        System.out.println(task.combine(1, 1));
        System.out.println(task.combine(20, 5));
    }
}
