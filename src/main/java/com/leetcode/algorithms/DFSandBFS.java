package com.leetcode.algorithms;

import com.leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.leetcode.tools.TreeNode.createTree;

public class DFSandBFS {


    public void dfs(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.removeLast();
            print(current);
            if (current.right != null) {
                stack.addLast(current.right);
            }
            if (current.left != null) {
                stack.addLast(current.left);
            }
        }
    }

    public void bfs(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.removeFirst();
            print(current);
            if (current.left != null) {
                queue.addLast(current.left);
            }
            if (current.right != null) {
                queue.addLast(current.right);
            }
        }
    }


    private void print(TreeNode node) {
        System.out.print(node.val + "  ");
    }


    public static void main(String[] args) {
        DFSandBFS task = new DFSandBFS();

        //                  1
        //       2                   6
        // 3           5                    7
        //    4                         8       9
        TreeNode tree1 = createTree(new Integer[]{1, 2, 6, 3, 5, null, 7, null, 4, null, null, 8, 9});
        task.dfs(tree1); // 1  2  3  4  5  6  7  8  9
        System.out.println();
        task.bfs(tree1); // 1  2  6  3  5  7  4  8  9
    }
}
