package com.leetcode;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class BinaryTreeMaximumPathSum {
    private int maxSum ;

//    public int maxPathSum(TreeNode root) {
//        maxSum = Integer.MIN_VALUE;
//        maxPathSum2(root);
//        return maxSum;
//    }
//
//    public int calculateMaxPath(TreeNode node) {
//        if (node == null) return 0;
//        int leftMaxPath = calculateMaxPath(node.left);
//        int rightMaxPath = calculateMaxPath(node.right);
//
//        int pathSum = leftMaxPath + node.val + rightMaxPath;
//        if (pathSum > maxSum) {
//            maxSum = pathSum;
//        }
//
//        return Math.max(leftMaxPath, rightMaxPath) + node.val;
//    }

    public int maxPathSum(TreeNode root) {
        return calculateMaxPath(root).globalMax;
    }


    public PathResult calculateMaxPath(TreeNode node) {
        if (node == null) return new PathResult(0 , Integer.MIN_VALUE);

        PathResult left = calculateMaxPath(node.left);
        PathResult right = calculateMaxPath(node.right);

        int pathThrough = left.maxFromNode + node.val + right.maxFromNode;
        int maxFromNode = Math.max(left.maxFromNode, right.maxFromNode) + node.val;

        return new PathResult(maxFromNode, Math.max(pathThrough, Math.max(left.globalMax, right.globalMax)));
    }

//    private PathResult calculateMaxPath(TreeNode node) {
//        if (node == null) {
//            return new PathResult(0, Integer.MIN_VALUE);
//        }
//        PathResult left = calculateMaxPath(node.left);
//        PathResult right = calculateMaxPath(node.right);
//
//        int leftMax = Math.max(0, left.maxFromNode());    // I don't know why negative values should be skipped
//        int rightMax = Math.max(0, right.maxFromNode());  // Task doesn't have any about this. But test case needed
//
//        int pathThrough = leftMax + node.val + rightMax;
//        int maxFromNode = Math.max(leftMax, rightMax) + node.val;
//
//        return new PathResult(maxFromNode, Math.max(pathThrough, Math.max(left.globalMax(), right.globalMax())));
//    }

    private record PathResult(int maxFromNode, int globalMax) {}


    public static void main(String[] args) {
        BinaryTreeMaximumPathSum task = new BinaryTreeMaximumPathSum();

        System.out.println(task.maxPathSum(createTree(new Integer[]{2, -1})));
        System.out.println(task.maxPathSum(createTree(new Integer[]{1, 2, 3})));
        System.out.println(task.maxPathSum(createTree(new Integer[]{-10, 9, 20, null, null, 15, 7})));

    }
}
