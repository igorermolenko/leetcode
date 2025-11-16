package com.leetcode;

import com.leetcode.tools.ListNode;

import java.util.Stack;

import static com.leetcode.tools.ListNode.createList;

public class MaxTwinSumLinkedList {

    public int pairSum(ListNode head) {
        int maxSum = 0;
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null) {
            if (fast != null) {
                stack.push(slow.val);
                fast = fast.next != null ? fast.next.next : null;
            } else {
                int sum = slow.val + stack.pop();
                maxSum = Math.max(maxSum, sum);
            }
            slow = slow.next;
        }

        return maxSum;
    }


    public static void main(String[] args) {
        MaxTwinSumLinkedList task = new MaxTwinSumLinkedList();
        System.out.println(task.pairSum(createList(new int[]{5, 4, 2, 1})));
        System.out.println(task.pairSum(createList(new int[]{4, 2, 2, 3})));
        System.out.println(task.pairSum(createList(new int[]{1, 100000})));
    }
}

