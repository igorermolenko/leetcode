package com.leetcode;

import com.leetcode.tools.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class MergeKSortedLists {

    // ================================================
    // ======================== Merge lists in pairs (divide and conquer)                            1ms
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int step = 1;
        while (step < lists.length) {
            for (int i = 0; i < lists.length - step; i += step * 2) {
                lists[i] = merge2Lists(lists[i], lists[i + step]);
            }
            step *= 2;
        }

        return lists[0];
    }


    // ================================================
    // ======================== Use priority queue                                              8 ms
    public ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return dummyHead.next;
    }


    // ================================================
    // ======================== Merge lists one by one                                          82 ms

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];

        for (int i = 1; i < lists.length; i++) {
            result = merge2Lists(result, lists[i]);
        }

        return result;
    }

    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;

        return dummyHead.next;
    }


    // ================================================
    // ======================== Merge all lists simultaneously, find minimum element on each step      140 ms

    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        int nextMinIdx = getNextMinIdx(lists);

        while (nextMinIdx >= 0) {
            cur.next = lists[nextMinIdx];
            lists[nextMinIdx] = lists[nextMinIdx].next;
            nextMinIdx = getNextMinIdx(lists);
            cur = cur.next;
        }

        return dummyHead.next;
    }

    private int getNextMinIdx(ListNode[] lists) {
        int idx = -1;
        int val = Integer.MAX_VALUE;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < val) {
                idx = i;
                val = lists[i].val;
            }
        }
        return idx;
    }


    public static void main(String[] args) {
        MergeKSortedLists task = new MergeKSortedLists();
        print(task.mergeKLists(new ListNode[]{createList(new int[]{1, 4, 5}), createList(new int[]{1, 3, 4}), createList(new int[]{2, 6})}));
        print(task.mergeKLists(new ListNode[]{}));
        print(task.mergeKLists(new ListNode[]{createList(new int[]{})}));
    }
}
