package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }


        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode buildTree(int[] preorder, int preorderFirst, int preorderLast,
                               int[] inorder, int inorderFirst, int inorderLast,
                               Map<Integer, Integer> inorderMap) {
        if (preorderFirst > preorderLast) {
            return null;
        }
        if (!inorderMap.containsKey(preorder[preorderFirst])) {
            throw new IllegalArgumentException("Inconsistent inorder array");
        }

        TreeNode root = new TreeNode(preorder[preorderFirst]);

        Integer inorderRootIdx = inorderMap.get(root.val);
        int leftSize = inorderRootIdx - inorderFirst;

        root.left = buildTree(
                preorder, preorderFirst + 1, preorderFirst + leftSize,
                inorder, inorderFirst, inorderRootIdx, inorderMap);
        root.right = buildTree(
                preorder, preorderFirst + leftSize + 1, preorderLast,
                inorder, inorderRootIdx + 1, inorderLast, inorderMap);

        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal2 task = new ConstructBinaryTreeFromPreorderAndInorderTraversal2();
        TreeNode tree1 = task.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(tree1);
        TreeNode tree2 = task.buildTree(new int[]{-1}, new int[]{-1});
        System.out.println(tree2);
        TreeNode tree3 = task.buildTree(new int[]{3, 9, 20, 15, 1, 2, 7}, new int[]{9, 3, 1, 15, 2, 20, 7});
        System.out.println(tree3);
    }
}

