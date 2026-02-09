package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class PartitionList {

    public ListNode partition1(ListNode head, int x) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;

        ListNode left = dummyHead;
        while (left.next != null && left.next.val < x) {
            left = left.next;
        }

        ListNode right = left;
        while (right.next != null) {
            if (right.next.val < x) {
                ListNode leftNextTmp = left.next;
                ListNode rightNextTmp = right.next.next;
                left.next = right.next;
                right.next.next = leftNextTmp;
                right.next = rightNextTmp;
                left = left.next;
            } else {
                right = right.next;
            }
        }

        return dummyHead.next;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                less.next = current;
                less = less.next;
            } else {
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }

        less.next = greaterHead.next;
        greater.next = null;
        return lessHead.next;
    }





    public static void main(String[] args) {
        PartitionList task = new PartitionList();
        print(task.partition(createList(new int[]{1, 4, 3, 2, 5, 2}), 3));
        print(task.partition(createList(new int[]{2, 1}), 2));
    }
}

