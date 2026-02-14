package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.Objects;

import static com.leetcode.tools.TreeNode.createTree;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return Objects.equals(p.val, q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree task = new SameTree();
        System.out.println(task.isSameTree(createTree(new Integer[]{1, 2, 3}), createTree(new Integer[]{1, 2, 3})));
        System.out.println(task.isSameTree(createTree(new Integer[]{1, 2}), createTree(new Integer[]{1, null, 2})));
        System.out.println(task.isSameTree(createTree(new Integer[]{1, 2, 1}), createTree(new Integer[]{1, 1, 2})));
    }
}

