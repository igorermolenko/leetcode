package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        addPermutations(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
        return result;
    }

    private void addPermutations(int[] nums, List<List<Integer>> result, List<Integer> permutation, boolean[] used) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            permutation.add(nums[i]);
            addPermutations(nums, result, permutation, used);
            permutation.removeLast();
            used[i] = false;
        }
    }

//    private void addPermutations(int[] nums, List<List<Integer>> result, Set<Integer> permutation) {
//        if (permutation.size() == nums.length) {
//            result.add(new ArrayList<>(permutation));
//            return;
//        }
//
//        for (int num: nums) {
//            if (permutation.contains(num)) continue;
//            permutation.add(num);
//            addPermutations(nums, result, permutation);
//            permutation.remove(num);
//        }
//    }
//

    public static void main(String[] args) {
        Permutations task = new Permutations();
        System.out.println(task.permute(new int[]{1, 2, 3}));
        System.out.println(task.permute(new int[]{0, 1}));
        System.out.println(task.permute(new int[]{1}));
    }
}
