package com.geek.algorithm.homework.week10;

/**
 *
 *
 * 191. 位1的个数
 *    https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        while(n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public int hammingWeight1(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        NumberOf1Bits191 action = new NumberOf1Bits191();
        action.hammingWeight(6);
    }

}
