package com.geek.algorithm.homework.week1;

import com.geek.algorithm.homework.ListNode;

/**
 * @author nick
 * @date 2021/6/22 9:25 PM
 * @package com.geek.algorithm.homework.week1
 * @description
 *  合并两个有序表
 *      https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeList21 {

    /**
     *
     * 递归调用
     *
     * @param l1
     * @param l2
     * @return
     *
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 先判断边界问题
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    /**
     *
     * 迭代调用
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 新建一个哨兵
        ListNode preHead = new ListNode(-1);
        // 定义一个移动指针
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead;
    }

}
