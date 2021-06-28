package com.geek.algorithm.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nick
 * @date 2021/6/28 10:38 PM
 * @package com.geek.algorithm.practice
 * @description
 */
public class Combine77 {


    public void setSub() {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        findSubSet(nums, 0);

    }
    public List<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    public List<Integer> s = new ArrayList<>();
    public int n = 4;
    public int k = 2;
    public void findSubSet(int[] nums, int index) {
        System.out.println("=========== start ===========");
        System.out.println("index:" + index +  ", ans:" + ans.toString());
        System.out.println("----------- end ----------- ");
        if (nums.length == index) {
            if (s.size() == k) {
                ans.add(new ArrayList<>(s));
            }
            return;
        }
        findSubSet(nums, index + 1);
        s.add(nums[index]);
        findSubSet(nums, index + 1);
        s.remove(s.size() - 1);
    }


    public static void main(String[] args) {
        Combine77 combine77 = new Combine77();
        combine77.setSub();
    }

}
