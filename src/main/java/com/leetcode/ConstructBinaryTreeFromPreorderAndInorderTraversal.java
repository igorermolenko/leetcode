package com.leetcode;

import com.leetcode.tools.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preorderFirst, int preorderLast,
                               int[] inorder, int inorderFirst, int inorderLast) {
        if (preorderFirst > preorderLast) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderFirst]);
        for (int i = inorderFirst; i <= inorderLast; i++) {
            if (inorder[i] == root.val) {
                int leftSize = i - inorderFirst;

                root.left = buildTree(
                        preorder, preorderFirst + 1, preorderFirst + leftSize,
                        inorder, inorderFirst, i);
                root.right = buildTree(
                        preorder, preorderFirst + leftSize + 1, preorderLast,
                        inorder, i + 1, inorderLast);

                return root;
            }
        }
        throw new IllegalArgumentException("Inconsistent inorder array");
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal task = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode tree1 = task.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(tree1);
        TreeNode tree2 = task.buildTree(new int[]{-1}, new int[]{-1});
        System.out.println(tree2);
        TreeNode tree3 = task.buildTree(new int[]{3, 9, 20, 15, 1, 2, 7}, new int[]{9, 3, 1, 15, 2, 20, 7});
        System.out.println(tree3);
    }
}

