package com.geek.algorithm.homework.week6;


import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * 673. 最长递增子序列的个数
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 *
 */
public class NumberOfLongestIncreasingSubsequence673 {


    /**
     *
     *
     *
     * @param nums
     * @return
     */
    public int findNumberOfLISBak(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i) if (nums[i] < nums[j]) {
                if (lengths[i] >= lengths[j]) {
                    lengths[j] = lengths[i] + 1;
                    counts[j] = counts[i];
                } else if (lengths[i] + 1 == lengths[j]) {
                    counts[j] += counts[i];
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length: lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // 记录最长子序列长度
        int[] dp = new int[n];
        // 记录以nums[i]结尾的子序列数量
        int[] count = new int[n];
        // 默认肯定有子序列的数量为1
        Arrays.fill(count, 1);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        // 最长的
        int lst = Arrays.stream(dp).max().getAsInt();
        for (int i = 0; i < n; i++) {
            if (dp[i] == lst) {
                ans += count[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence673 action = new NumberOfLongestIncreasingSubsequence673();
        int[] nums = new int[]{1,3,5,4,7};
        action.findNumberOfLIS(nums);

    }


}
