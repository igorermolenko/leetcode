package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.*;

import static com.leetcode.tools.TreeNode.createTree;

public class PathSumIII {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSum2Count = new HashMap<>() {{
            put(0L, 1);
        }};
        return pathSum(root, targetSum, 0, prefixSum2Count);

    }

    public int pathSum(TreeNode root, int targetSum, long prefixSum, Map<Long, Integer> prefixSum2Count) {
        if (root == null) return 0;
        prefixSum += root.val;
        int result = prefixSum2Count.getOrDefault(prefixSum - targetSum, 0);
        prefixSum2Count.put(prefixSum , prefixSum2Count.getOrDefault(prefixSum, 0) + 1);
        result += pathSum(root.left, targetSum, prefixSum, prefixSum2Count);
        result += pathSum(root.right, targetSum, prefixSum, prefixSum2Count);
        prefixSum2Count.put(prefixSum , prefixSum2Count.get(prefixSum) - 1);
        return result;
    }



    public static void main(String[] args) {
        PathSumIII task = new PathSumIII();
        System.out.println(task.pathSum(createTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8));
        System.out.println(task.pathSum(createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));
        System.out.println(task.pathSum(createTree(new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000}), 0));
    }
}
