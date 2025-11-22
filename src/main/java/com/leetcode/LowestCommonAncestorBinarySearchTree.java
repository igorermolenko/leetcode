package com.leetcode;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class LowestCommonAncestorBinarySearchTree {

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;

        while (node != null) {
            if (p.val > node.val && q.val > node.val) {
                node = node.right;
            } else if (p.val < node.val && q.val < node.val) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }



    public static void main(String[] args) {
        LowestCommonAncestorBinarySearchTree task = new LowestCommonAncestorBinarySearchTree();
        TreeNode tree1 = createTree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        System.out.println(task.lowestCommonAncestor(tree1, tree1.getNode(2), tree1.getNode(8)));
        System.out.println(task.lowestCommonAncestor(tree1, tree1.getNode(2), tree1.getNode(4)));
        TreeNode tree2 = createTree(new Integer[]{2, 1});
        System.out.println(task.lowestCommonAncestor(tree2, tree2.getNode(2), tree2.getNode(1)));
    }
}
