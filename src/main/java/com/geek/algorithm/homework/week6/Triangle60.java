package com.geek.algorithm.homework.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle60 {

    /**
     *
     * 120. 三角形最小路径和
     * https://leetcode-cn.com/problems/triangle/description/
     *
     * @param triangle
     * @return
     *
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[n][m];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = dp[n-1][0];
        for (int i = 0; i < n; i++) {
            minTotal = Math.min(dp[n - 1][i], minTotal);
        }
        return minTotal;
    }

    /**
     *
     * 两数组交互
     *
     * @param triangle
     * @return
     *
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[2][m];
        dp[0][0] = triangle.get(0).get(0);
        // 从第一行开始
        for (int i = 1; i < n; i++) {
            int cur = i % 2;
            int prev = 1 - cur;
            dp[cur][0] = dp[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[cur][j] = Math.min(dp[prev][j], dp[prev][j-1]) + triangle.get(i).get(j);
            }
            dp[cur][i] = dp[prev][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = dp[(n - 1) % 2][0];
        for (int i = 1; i < n; i++) {
            System.out.println("i = " + i + ", minTotal:" + minTotal + ", value:" + dp[(n - 1) % 2][i]);
            minTotal = Math.min(dp[(n-1) % 2][i], minTotal);
        }
        return minTotal;
    }

    /**
     *
     * 一行数组搞定
     * 倒查询
     * @param triangle
     * @return
     *
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            // 注意是从i-1开始
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int minTotal = 0;
        for (int i = 0; i < n; i++) {
            minTotal = Math.min(dp[i], minTotal);
        }
        return minTotal;
    }

    public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<List<Integer>>(){{
        add(Arrays.asList(2));
        add(Arrays.asList(3, 4));
        add(Arrays.asList(6, 5, 7));
        add(Arrays.asList(4, 1, 8, 3));
    }};
    Triangle60 action = new Triangle60();
    int result = action.minimumTotal3(triangle);
    System.out.println("Triangle60 result:" + result);

    }
}
