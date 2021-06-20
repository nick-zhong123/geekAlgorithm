package com.geek.algorithm.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nick
 * @date 2021/6/20 6:23 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *  https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum1 {

    /**
     *
     * 两个之和，hashmap方式
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer>  map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
