package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static com.leetcode.tools.TreeNode.createTree;

public class BinaryTreeInorderTraversal {

    // More complex Stack-only solution
    // Stack-only solutions require extra bookkeeping (markers, flags, or node copies),
    // making them less readable with no performance benefit.
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                result.add(node.val);
            } else if (node.left == null) {
                stack.push(node.right);
                result.add(node.val);
            } else {
                if (node.right != null) stack.push(node.right);
                // By pushing a leaf node (no children), the algorithm recognizes it as "ready to add to result" because:
                // node.left == null && node.right == null → add to result immediately
                stack.push(new TreeNode(node.val)); // leaf copy
                stack.push(node.left);
            }
        }
        return result;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }


    public static void main(String[] args) {
        BinaryTreeInorderTraversal task = new BinaryTreeInorderTraversal();

        System.out.println(task.inorderTraversal(createTree(new Integer[]{1, null, 2, 3})));
        System.out.println(task.inorderTraversal(createTree(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9})));
        System.out.println(task.inorderTraversal(createTree(new Integer[]{})));
        System.out.println(task.inorderTraversal(createTree(new Integer[]{1})));

    }
}
