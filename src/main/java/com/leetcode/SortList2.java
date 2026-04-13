package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class SortList2 {

    public ListNode sortList(ListNode head) {

        int length = getLength(head);

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (int size = 1; size < length; size *= 2) {
            ListNode tail = dummy;
            ListNode current = dummy.next;
            while (current != null) {
                ListNode left = current;
                ListNode right = split(left, size);
                current = split(right, size);
                tail = merge(left, right, tail);
            }
        }

        return dummy.next;
    }


    private ListNode split(ListNode head, int size) {
        for (int i = 1; i < size && head != null; i++) {
            head = head.next;
        }
        if (head == null) {
            return  null;
        }
        ListNode next = head.next;
        head.next = null;
        return next;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode tail) {
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else  {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = left != null ? left : right;
        while (tail.next != null) {
            tail = tail.next;
        }

        return tail;
    }

    private int getLength(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }
        return length;
    }


    public static void main(String[] args) {
        SortList2 task = new SortList2();
        print(task.sortList(createList(new int[]{4, 2, 1, 3})));
        print(task.sortList(createList(new int[]{-1, 5, 3, 4, 0})));
        print(task.sortList(createList(new int[]{})));
    }
}
