package com.leetcode;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class LongestZigZag {

    public int longestZigZag2(TreeNode root) {
        return Math.max(longestZigZag(root.left, true), longestZigZag(root.right, false));
    }

    public int longestZigZag(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        return Math.max(
                longestZigZag(root.left, true) + (isLeft ? 0 : 1),
                longestZigZag(root.right, false) + (isLeft ? 1 : 0));

    }


    private int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        maxLength = 0;
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxLength;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) {
            return;
        }

        maxLength = Math.max(maxLength, length);

        dfs(node.left, false, isLeft ? length + 1 : 1);
        dfs(node.right, true, isLeft ? 1 : length + 1);
    }

    public static void main(String[] args) {
        LongestZigZag task = new LongestZigZag();
        System.out.println(task.longestZigZag(createTree(new Integer[]{1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1})));
        System.out.println(task.longestZigZag(createTree(new Integer[]{1, 2, 0, null, 3, null, null, 4, 0, null, 5})));
        System.out.println(task.longestZigZag(createTree(new Integer[]{1})));
        System.out.println(task.longestZigZag(createTree(new Integer[]{6, 9, 7, 3, null, 2, 8, 5, 8, 9, 7, 3, 9, 9, 4, 2, 10, null, 5, 4, 3, 10, 10, 9, 4, 1, 2, null, null, 6, 5, null, null, null, null, 9, null, 9, 6, 5, null, 5, null, null, 7, 7, 4, null, 1, null, null, 3, 7, null, 9, null, null, null, null, null, null, null, null, 9, 9, null, null, null, 7, null, null, null, null, null, null, null, null, null, 6, 8, 7, null, null, null, 3, 10, null, null, null, null, null, 1, null, 1, 2})));
    }
}
