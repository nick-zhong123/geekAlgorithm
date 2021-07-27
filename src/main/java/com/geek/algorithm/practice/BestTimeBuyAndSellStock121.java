package com.geek.algorithm.practice;

public class BestTimeBuyAndSellStock121 {

    /**
     *
     *  121. 买卖股票的最佳时机
     *  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     *   dp空间变为 n*2
     * @param prices
     * @return
     *
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // dp[i][0] 未持有股票
        // dp[i][1] 持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
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
        int[] dp = new int[2];
        // dp[0] 未持有股票
        // dp[1] 持有股票
        dp[1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[0] = Math.max(dp[1] + prices[i], dp[0]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
       return dp[0];
    }


}
