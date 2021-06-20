package com.geek.algorithm.practice;

/**
 * @author nick
 * @date 2021/6/20 11:53 AM
 * @package com.geek.algorithm
 * @description
 *  第一周预习课
 *   https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RmDuplicates {

    /**
     *
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast - 1] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

}
