package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {

        return head;
    }


    public static void main(String[] args) {
        OddEvenLinkedList task = new OddEvenLinkedList();
        print(task.oddEvenList(createList(new int[]{1, 2, 3, 4, 5})));
        print(task.oddEvenList(createList(new int[]{2, 1, 3, 5, 6, 4, 7})));
    }
}

