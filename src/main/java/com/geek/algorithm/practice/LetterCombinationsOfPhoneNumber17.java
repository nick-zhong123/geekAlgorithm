package com.geek.algorithm.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nick
 * @date 2021/7/6 9:00 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *   17. 电话号码的字母组合
 *   https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber17 {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        ans = new ArrayList<>();
        set = new ArrayList<>();

        nums = new ArrayList<>();
        // 0
        nums.add(new ArrayList<>());
        // 1
        nums.add(new ArrayList<>());
        // 2
        nums.add(Arrays.asList('a','b','c'));
        // 3
        nums.add(Arrays.asList('d','e','f'));
        // 4
        nums.add(Arrays.asList('g','h','i'));
        // 5
        nums.add(Arrays.asList('j','k','l'));
        // 6
        nums.add(Arrays.asList('m','n','o'));
        // 7
        nums.add(Arrays.asList('p','q','r','s'));
        // 8
        nums.add(Arrays.asList('t','u','v'));
        // 9
        nums.add(Arrays.asList('x','y','z'));
        dfs(digits, 0);
        return ans;
    }

    public void dfs(String digits, int index) {
        if (index == digits.length()) {
            ans.add(set.toString());
            return;
        }
        int n = Integer.parseInt(digits.substring(index, index + 1));
        List<String> data = nums.get(n);
        for (String str : data) {
            set.add(str);
            dfs(digits, index + 1);
            set.remove(set.size() - 1);
        }
    }

    private List<String> set;
    private List<List<String>> nums;
    private List<String> ans;

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber17 exec = new LetterCombinationsOfPhoneNumber17();
        String digits = '23';
        List<String> result = exec.letterCombinations(digits);
        System.out.println('result:' + result.toString());
    }

}
