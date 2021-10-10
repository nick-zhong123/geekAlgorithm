package com.geek.algorithm.practice;

import java.util.PriorityQueue;

/**
 *
 *
 * 23. 合并K个升序链表
 *      https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists23 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        public Status (int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status s) {
            return this.val - s.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<>();

    public ListNode mergeKLists(ListNode[] lists) {
        for(ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!queue.isEmpty()) {
            Status tmp = queue.poll();
            tail.next = tmp.ptr;
            tail = tail.next;
            if (tmp.ptr.next != null) {
                queue.offer(new Status(tmp.ptr.next.val, tmp.ptr.next));
            }
        }

        return head.next;
    }

}
