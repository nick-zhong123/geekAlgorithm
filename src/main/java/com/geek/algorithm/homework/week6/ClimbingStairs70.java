package com.geek.algorithm.homework.week6;

/**
 *
 *
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs70 {

    public int climbStairs(int n) {
        int first = 0;
        int second = 0;
        int third = 1;
        for (int i = 1; i < n; i++) {
            first = second;
            second = third;
            third = first + second;
        }
        return third;
    }

    public static void main(String[] args) {
        ClimbingStairs70 action = new ClimbingStairs70();


    }
}
