package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }

        int removeIndex = size - n;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        current = dummy;
        for (int i = 0; i < removeIndex; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }


    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList task = new RemoveNthNodeFromEndOfList();
        print(task.removeNthFromEnd(createList(new int[]{1, 2, 3, 4, 5}), 2));
        print(task.removeNthFromEnd(createList(new int[]{1}), 1));
        print(task.removeNthFromEnd(createList(new int[]{1, 2}), 1));
    }
}

