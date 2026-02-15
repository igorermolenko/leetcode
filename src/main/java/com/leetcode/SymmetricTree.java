package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static com.leetcode.tools.TreeNode.createTree;

public class SymmetricTree {

    public boolean isSymmetric2(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val) && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }


    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();

            if (p == null && q == null) {
                continue;
            } else if (p == null || q == null) {
                return false;
            } else {
                if (p.val != q.val) return false;

                queue.offer(p.left);
                queue.offer(q.right);
                queue.offer(q.left);
                queue.offer(p.right);
            }
        }

        return true;
    }


    public static void main(String[] args) {
        SymmetricTree task = new SymmetricTree();
        System.out.println(task.isSymmetric(createTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        System.out.println(task.isSymmetric(createTree(new Integer[]{1, 2, 2, null, 3, null, 3})));
    }
}

