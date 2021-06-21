package com.geek.algorithm.homework.week1;

import java.util.Arrays;

/**
 * @author nick
 * @date 2021/6/21 10:47 PM
 * @package com.geek.algorithm.homework.week1
 * @description
 *
 *   加一（Easy）
 *   https://leetcode-cn.com/problems/plus-one/solution/
 *
 */
public class PlusOne66 {

    /**
     * 加1
     *
     * @param nums
     * @return
     */
    public static int[] plusOne(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] += 1;
            nums[i] %= 10;
            if (nums[i] != 0) {
                return nums;
            }
        }
        int[] newNums = new int[nums.length +1];
        newNums[0] = 1;

        return newNums;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{1, 2, 9};
        int[] nums3 = new int[]{9, 9, 9};

        System.out.println("Plus One, {1, 2, 3}: " + Arrays.toString(plusOne(nums1)));
        System.out.println("Plus One, {1, 2, 9}: " + Arrays.toString(plusOne(nums2)));
        System.out.println("Plus One, {9, 9, 9}: " + Arrays.toString(plusOne(nums3)));
    }




}
