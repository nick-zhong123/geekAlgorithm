package com.geek.algorithm.practice;

public class ThirdMaximumNumber414 {

    /**
     *
     * 414. 第三大的数
     * https://leetcode-cn.com/problems/third-maximum-number/
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        Integer a = null;
        Integer b = null;
        Integer c = null;
        for (int num : nums) {
            if (a == null || num > a) {
                c = b; b = a; a = num;
            } else if (a > num && (b == null || num > b)) {
                c = b; b = num;
            } else if (b != null && b > num && (c == null || num > c)){
                c = num;
            }
        }
        return c == null ? a : c;
    }

}
