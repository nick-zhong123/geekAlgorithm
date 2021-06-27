package com.geek.algorithm.practice;

/**
 * @author nick
 * @date 2021/6/23 10:37 PM
 * @package com.geek.algorithm.practice
 * @description
 */
public class NumberOfSubArrays1248 {


    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int odd = 0, ans = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; ++i) {
            odd += nums[i] & 1;
            ans += odd >= k ? cnt[odd - k] : 0;
            cnt[odd] += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,1,1};
        int k = 3;
        numberOfSubarrays(nums, k);

    }

}
