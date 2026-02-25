package com.leetcode.algorithms;

import com.leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.leetcode.tools.TreeNode.createTree;

public class PreorderTraversal {

    public void traverse(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                print(current);
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            current = current.right;
        }

    }



    private void print(TreeNode node) {
        System.out.print(node.val + "  ");
    }


    public static void main(String[] args) {
        PreorderTraversal task = new PreorderTraversal();

        TreeNode tree1 = createTree(new Integer[]{5, 2, 6, 1, 4, null, 7, null, null, 3, null, null, 8}); // 5  2  1  4  3  6  7  8
        task.traverse(tree1);
        System.out.println();
        TreeNode tree2 = createTree(new Integer[]{5, 4, null, 3, null, 2, null, 1, null}); // 5  4  3  2  1
        task.traverse(tree2);
    }
}
