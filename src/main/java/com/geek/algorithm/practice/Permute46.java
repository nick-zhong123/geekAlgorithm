package com.geek.algorithm.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nick
 * @date 2021/6/28 11:36 PM
 * @package com.geek.algorithm.practice
 * @description
 */
public class Permute46 {

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        num = new int[n];
        for (int i = 0; i < n; i++)
            num[i] = nums[i];
        used = new boolean[n];
        per = new ArrayList<Integer>();
        ans = new ArrayList<List<Integer>>();
        dfs(0);
        return ans;
    }

    private void dfs(int depth) {
        if (depth == n) {
            ans.add(new ArrayList<Integer>(per));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            used[i] = true;
            per.add(num[i]);
            dfs(depth + 1);
            per.remove(per.size() - 1);
            used[i] = false;
        }
    }

    private int n;
    private int[] num;
    private boolean[] used;
    private List<Integer> per;
    private List<List<Integer>> ans;

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Permute46 permute46 = new Permute46();
        permute46.permute(nums);
    }
}
