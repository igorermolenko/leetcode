package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.leetcode.tools.TreeNode.createTree;

public class BSTIterator {
    private final Deque<TreeNode> stack = new ArrayDeque<>();
    private TreeNode current;
    private boolean moveToRight = false;


    public BSTIterator(TreeNode root) {
        current = root;
        moveToNext();
    }

    public int next() {
        int val = current.val;
        moveToNext();
        return val;
    }

    public boolean hasNext() {
        return current != null;
    }


    private void moveToNext() {
        while (!stack.isEmpty() || current != null) {
            if (moveToRight) {
                current = current.right;
                moveToRight = false;
            } else {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                moveToRight = true;

                if (current != null) {
                    return;
                }
            }

        }

    }


    public static void main(String[] args) {
        TreeNode tree1 = createTree(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator bSTIterator = new BSTIterator(tree1);
        System.out.println(bSTIterator.next());    // return 3
        System.out.println(bSTIterator.next());    // return 7
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 9
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 15
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 20
        System.out.println(bSTIterator.hasNext()); // return False
    }
}
