package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.leetcode.tools.TreeNode.createTree;

public class BinaryTreeLevelOrederTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelItems = new ArrayList<>();
            for(int i=0; i<levelSize;i++) {
                TreeNode node = queue.poll();
                levelItems.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(levelItems);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrederTraversal task = new BinaryTreeLevelOrederTraversal();
        System.out.println(task.levelOrder(createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(task.levelOrder(createTree(new Integer[]{1})));
        System.out.println(task.levelOrder(createTree(new Integer[]{})));
    }
}
