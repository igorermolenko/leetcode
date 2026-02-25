package com.leetcode.algorithms;

import com.leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.leetcode.tools.TreeNode.createTree;

public class PostorderTraversal {

    public void traverse(TreeNode root) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            print(stack2.pop());
        }
    }


    private void print(TreeNode node) {
        System.out.print(node.val + "  ");
    }


    public static void main(String[] args) {
        PostorderTraversal task = new PostorderTraversal();

        TreeNode tree1 = createTree(new Integer[]{5, 2, 6, 1, 4, null, 7, null, null, 3, null, null, 8}); // 1  3  4  2  8  7  6  5
        task.traverse(tree1);
        System.out.println();
        TreeNode tree2 = createTree(new Integer[]{5, 4, null, 3, null, 2, null, 1, null}); // 1,2,3,4,5
        task.traverse(tree2);
    }
}
