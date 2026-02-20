package com.leetcode;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class PathSum {

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathSum(root, 0, targetSum);
    }

    private boolean hasPathSum(TreeNode root, int prevSum, int targetSum) {
        int curSum = prevSum + root.val;
        if (root.left == null && root.right == null) {
            return curSum == targetSum;
        }
        return (root.left != null && hasPathSum(root.left, curSum, targetSum)) ||
                (root.right != null && hasPathSum(root.right, curSum, targetSum));
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return (root.left != null && hasPathSum(root.left, targetSum - root.val)) ||
                (root.right != null && hasPathSum(root.right, targetSum - root.val));
    }


    public static void main(String[] args) {
        PathSum task = new PathSum();
        System.out.println(task.hasPathSum(createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
        System.out.println(task.hasPathSum(createTree(new Integer[]{1, 2, 3}), 5));
        System.out.println(task.hasPathSum(createTree(new Integer[]{}), 0));
    }
}

