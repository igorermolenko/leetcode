package com.leetcode;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class BinaryTreeMaxDepth {

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;

        return maxDepth;
    }


    public static void main(String[] args) {
        BinaryTreeMaxDepth task = new BinaryTreeMaxDepth();
        System.out.println(task.maxDepth(createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(task.maxDepth(createTree(new Integer[]{1, null, 2})));
    }
}
