package com.geek.algorithm.practice;

/**
 * @author nick
 * @date 2021/6/20 2:08 PM
 * @package com.geek.algorithm.practice
 * @description
 *  leetcode第88题
 *      合并两数组
 *      https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Merge88 {

    /**
     *
     * 从前往后合并
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     *
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];
        int cur;
        int p1 = 0;
        int p2 = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }

    /**
     *
     * 从后往前合并
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while(p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

}
