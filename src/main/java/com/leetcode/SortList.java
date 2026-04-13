package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class SortList {

    public ListNode sortList(ListNode head) {
        ListNode sortedHead = new ListNode(Integer.MIN_VALUE);
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            ListNode insertPos = sortedHead;

            while (insertPos.next != null && insertPos.next.val < current.val) {
                insertPos = insertPos.next;
            }

            ListNode temp = insertPos.next;
            insertPos.next = current;
            current.next = temp;

            current = next;
        }

        return sortedHead.next;
    }


    public static void main(String[] args) {
        SortList task = new SortList();
        print(task.sortList(createList(new int[]{4, 2, 1, 3})));
        print(task.sortList(createList(new int[]{-1, 5, 3, 4, 0})));
        print(task.sortList(createList(new int[]{})));
    }
}
