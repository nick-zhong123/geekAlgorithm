package com.geek.algorithm.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nick
 * @date 2021/6/28 9:19 PM
 * @package com.geek.algorithm.practice
 * @description
 *  78. 子集
 *      https://leetcode-cn.com/problems/subsets/
 */
public class Subsets78 {

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        s = new ArrayList<Integer>();
        findSubsets(nums, 0);
        System.out.println("ans:" + ans.toString());

        return ans;
    }

    private void findSubsets(int[] nums, int index) {
        System.out.println("=========== start ===========");
        System.out.println("index:" + index +  ", ans:" + ans.toString());
        System.out.println("----------- end ----------- ");
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(s));
            return;
        }
        findSubsets(nums, index + 1);
        s.add(nums[index]);
        findSubsets(nums, index + 1);
        s.remove(s.size() - 1);
    }

    private List<List<Integer>> ans;
    private List<Integer> s;

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Subsets78 subsets78 = new  Subsets78();
        subsets78.subsets(nums);
    }
}
