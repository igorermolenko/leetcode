package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList task = new RemoveDuplicatesFromSortedList();
        print(task.deleteDuplicates(createList(new int[]{1, 1, 2})));
        print(task.deleteDuplicates(createList(new int[]{1, 1, 2, 3, 3})));
    }
}

