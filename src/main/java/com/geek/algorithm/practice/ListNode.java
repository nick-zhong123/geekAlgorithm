package com.geek.algorithm.practice;

/**
 *
 * @author nick
 * @date 2021/6/21 2:55 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *   链表公共节点
 *
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode () {}

    public ListNode (int _val) {
        this.val = _val;
    }

    public ListNode(int _val, ListNode _next) {
        this.val = _val;
        this.next = _next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
