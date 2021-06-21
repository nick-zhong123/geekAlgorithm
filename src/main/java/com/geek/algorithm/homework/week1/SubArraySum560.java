package com.geek.algorithm.homework.week1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nick
 * @date 2021/6/21 10:00 PM
 * @package com.geek.algorithm.homework
 * @description
 *
 * 和为 K 的子数组（Medium）
 *
 *     https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 */
public class SubArraySum560 {

    /**
     *
     * 枚举法
     *
     */
    public static int subArraySum1(int[] nums, int k) {
        int count  = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                // 这里重复计算了 start 至 end 之间的和
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     *
     * 枚举 + HashMap法
     *
     */
    public static int subArraySum2(int[] nums, int k) {
        int count = 0;
        // 记录从i开始的和
        int prev = 0;
        // 记录从0至i的每个和
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // 计算所有的prev
        for (int i = 0; i < nums.length; i++) {
            prev += nums[i];
            if (map.containsKey(prev - k)) {
                // 累计求和
                count += map.get(prev - k);
            }
            // 统计当前累加值出现的次数
            map.put(prev, map.getOrDefault(prev, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int k = 7;
        int[] array = new int[]{3, 4, 7, 2, -3, 1, 4, 2};
        int count1 = subArraySum1(array, k);
        int count2 = subArraySum2(array, k);
        System.out.println("枚举法求和, count1: " + count1);
        System.out.println("HashMap求和, count2: " + count2);
    }
}
