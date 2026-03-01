package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.function.Function;

import static com.leetcode.tools.TreeNode.createTree;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        return countNodes(root, -1, -1);
    }

    public int countNodes(TreeNode root, int leftHeight, int rightHeight) {
        if (root == null) return 0;

        leftHeight = leftHeight > 0 ? leftHeight : countHeight(root, node -> node.left);
        rightHeight = rightHeight > 0 ? rightHeight : countHeight(root, node -> node.right);

        if (leftHeight == rightHeight) {
//            return (int) Math.pow(2, leftHeight) - 1;
            return (1 << leftHeight) - 1; // Bit shift is faster than Math.pow
        } else {
            int lNodes = countNodes(root.left, leftHeight - 1, -1);
            int rNodes = countNodes(root.right, -1, rightHeight - 1);
            return lNodes + rNodes + 1;
        }
    }


    private int countHeight(TreeNode root, Function<TreeNode, TreeNode> next) {
        int height = 0;
        while (root != null) {
            height++;
            root = next.apply(root);
        }
        return height;
    }


    public static void main(String[] args) {
        CountCompleteTreeNodes task = new CountCompleteTreeNodes();

        System.out.println(task.countNodes(createTree(new Integer[]{1, 2, 3, 4, 5, 6})));
        System.out.println(task.countNodes(createTree(new Integer[]{})));
        System.out.println(task.countNodes(createTree(new Integer[]{1})));

    }
}
