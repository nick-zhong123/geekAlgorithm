package com.geek.algorithm.practice;

public class BestTimeBuyAndSellStock122 {

    /**
     *
     *  122. 买卖股票的最佳时机
     *  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     *  可以多次买卖
     *   dp空间变为 n*2
     * @param prices
     * @return
     *
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    /**
     *
     *   dp空间变为 2
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
       int n = prices.length;
       int dp0 = 0;
       int dp1 = -prices[0];
       for (int i = 0; i < n;  i++) {
           int ndp0 = Math.max(dp0, dp1 + prices[i]);
           int ndp1 = Math.max(dp1, dp0 - prices[i]);
           dp0 = ndp0;
           dp1 = ndp1;
       }
        return dp0;
    }


}
