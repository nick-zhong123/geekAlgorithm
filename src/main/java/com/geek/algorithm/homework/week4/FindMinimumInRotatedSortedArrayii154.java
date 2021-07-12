package com.geek.algorithm.homework.week4;

/**
 * @author nick
 * @date 2021/7/12 10:43 PM
 * @package com.geek.algorithm.homework.week4
 * @description
 *
 *   154. 寻找旋转排序数组中的最小值 II
 *   https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 */
public class FindMinimumInRotatedSortedArrayii154 {


    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                // 中间点落在单调递增更小点半段
                r = mid;
            } else if (nums[mid] > nums[r]) {
                // 中间点落在单调递增更大点半段
                l = mid + 1;
            } else {
                // 1111 mid 1111
                r = mid - 1;
            }
        }
        return nums[l];
    }


    public static void main(String[] args) {
        return;
    }

}
