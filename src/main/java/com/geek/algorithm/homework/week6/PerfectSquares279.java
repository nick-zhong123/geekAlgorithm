package com.geek.algorithm.homework.week6;

public class PerfectSquares279 {

    /**
     *
     *
     * 279. 完全平方数
     *
     *    https://leetcode-cn.com/problems/perfect-squares/
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {

        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        for (int i = 0; i <= n; i++) {
            System.out.println("i=" + i + ", f=" + f[i]);
        }
        return f[n];
    }

    public static void main(String[] args) {
        PerfectSquares279 action = new PerfectSquares279();
        action.numSquares(12);
    }
}
