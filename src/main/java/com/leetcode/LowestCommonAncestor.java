package com.leetcode;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


    public static void main(String[] args) {
        LowestCommonAncestor task = new LowestCommonAncestor();
        TreeNode tree1 = createTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println(task.lowestCommonAncestor(tree1, tree1.getNode(5), tree1.getNode(1)));
        System.out.println(task.lowestCommonAncestor(tree1, tree1.getNode(5), tree1.getNode(4)));
        TreeNode tree2 = createTree(new Integer[]{1, 2});
        System.out.println(task.lowestCommonAncestor(tree2, tree2.getNode(1), tree2.getNode(2)));
    }
}
