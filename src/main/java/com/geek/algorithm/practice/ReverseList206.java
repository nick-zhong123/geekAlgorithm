package com.geek.algorithm.practice;

/**
 *
 *
 * @author nick
 * @date 2021/6/21 2:55 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *
 */
public class ReverseList206 {

    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
