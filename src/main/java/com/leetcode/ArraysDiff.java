package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArraysDiff {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> diff1 = set1.stream().filter(num -> !set2.contains(num)).toList();
        List<Integer> diff2 = set2.stream().filter(num -> !set1.contains(num)).toList();
        return List.of(diff1, diff2);
    }


    public static void main(String[] args) {
        ArraysDiff diff = new ArraysDiff();
        System.out.println(diff.findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println(diff.findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }
}
