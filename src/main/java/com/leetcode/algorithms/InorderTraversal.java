package com.leetcode.algorithms;

import com.leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.leetcode.tools.TreeNode.createTree;

public class InorderTraversal {

    public void traverse(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            print(current);

            current = current.right;
        }

    }



    private void print(TreeNode node) {
        System.out.print(node.val + "  ");
    }


    public static void main(String[] args) {
        InorderTraversal task = new InorderTraversal();

        TreeNode tree1 = createTree(new Integer[]{5, 2, 6, 1, 4, null, 7, null, null, 3, null, null, 8}); // 1,2,3,4,5,6,7,8
        task.traverse(tree1);
        System.out.println();
        TreeNode tree2 = createTree(new Integer[]{5, 4, null, 3, null, 2, null, 1, null}); // 1,2,3,4,5
        task.traverse(tree2);
    }
}
