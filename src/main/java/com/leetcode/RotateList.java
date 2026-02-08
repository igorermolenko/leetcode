package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class RotateList {

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode slowCurrent = head;
        ListNode fastCurrent = head;
        for (int i = 0; i < k; i++) {
            fastCurrent = fastCurrent.next != null ? fastCurrent.next : head;
        }
        while (fastCurrent.next != null) {
            fastCurrent = fastCurrent.next;
            slowCurrent = slowCurrent.next;
        }

        fastCurrent.next = head;
        ListNode newHead = slowCurrent.next;
        slowCurrent.next = null;

        return newHead;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int length = 1;
        ListNode oldTail = head;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }

        k = k % length;
        if (k == 0) return head;

        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        oldTail.next = head;

        return newHead;
    }


    public static void main(String[] args) {
        RotateList task = new RotateList();
        print(task.rotateRight(createList(new int[]{1, 2, 3, 4, 5}), 2));
        print(task.rotateRight(createList(new int[]{0, 1, 2}), 4));
    }
}

