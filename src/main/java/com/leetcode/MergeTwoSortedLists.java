package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        ListNode current1 = list1, current2 = list2;

        while (current1 != null && current2 != null) {
            if (current1.val < current2.val) {
                head.next = current1;
                current1 = current1.next;
            } else {
                head.next = current2;
                current2 = current2.next;
            }
            head = head.next;
        }
        head.next = current1 != null ? current1 : current2;

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists task = new MergeTwoSortedLists();
        print(task.mergeTwoLists(createList(new int[]{1, 2, 4}), createList(new int[]{1, 3, 4})));
        print(task.mergeTwoLists(createList(new int[]{}), createList(new int[]{})));
        print(task.mergeTwoLists(createList(new int[]{}), createList(new int[]{0})));
    }
}

