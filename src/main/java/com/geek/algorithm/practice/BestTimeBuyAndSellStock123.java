package com.geek.algorithm.practice;

public class BestTimeBuyAndSellStock123 {

    /**
     *
     *  123. 买卖股票的最佳时机
     *  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
     *  可以多次买卖
     *   dp空间变为 n*2
     * @param prices
     * @return
     *
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][2];
        // 第一次买入
        dp[0][0] = -prices[0];
        // 第一次卖出
        dp[0][1] = 0;
        // 第二次买入
        dp[1][0] = -prices[0];
        // 第二次卖出
        dp[1][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[0][0] = Math.max(dp[0][0], -prices[i]);
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + prices[i]);
            dp[1][0] = Math.max(dp[1][0], dp[0][1] - prices[i]);
            dp[1][1] = Math.max(dp[1][1], dp[1][0] + prices[i]);
        }
        return dp[1][1];
    }


}
