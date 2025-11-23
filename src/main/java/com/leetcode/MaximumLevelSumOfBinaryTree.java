package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.*;

import static com.leetcode.tools.TreeNode.createTree;

public class MaximumLevelSumOfBinaryTree {


    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        int maxLevelSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int curLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                maxLevel = curLevel;
            }
            curLevel++;
        }


        return maxLevel;
    }

    public static void main(String[] args) {
        MaximumLevelSumOfBinaryTree task = new MaximumLevelSumOfBinaryTree();
        System.out.println(task.maxLevelSum(createTree(new Integer[]{1,7,0,7,-8,null,null})));
        System.out.println(task.maxLevelSum(createTree(new Integer[]{989,null,10250,98693,-89388,null,null,null,-32127})));
    }
}
