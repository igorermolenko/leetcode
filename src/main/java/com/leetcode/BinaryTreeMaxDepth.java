package com.leetcode;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class BinaryTreeMaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }


    public static void main(String[] args) {
        BinaryTreeMaxDepth task = new BinaryTreeMaxDepth();
        System.out.println(task.maxDepth(createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(task.maxDepth(createTree(new Integer[]{3, 9, 20, 4, 6, 15, 7, null, null, null, null, null, 75, null, null  })));
        System.out.println(task.maxDepth(createTree(new Integer[]{1, null, 2})));
    }
}
