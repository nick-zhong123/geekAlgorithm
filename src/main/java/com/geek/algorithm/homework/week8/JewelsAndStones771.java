package com.geek.algorithm.homework.week8;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 771. 宝石与石头
 * https://leetcode-cn.com/problems/jewels-and-stones/
 *
 */
public class JewelsAndStones771 {

    public int numJewelsInStones(String jewels, String stones) {
        char[] jewlesArr = jewels.toCharArray();
        char[] stonesArr = stones.toCharArray();
        int ans = 0;
        Set<Character> jewSet = new HashSet<>();
        int l1 = jewels.length();
        for (int i = 0; i < l1; i++) {
            jewSet.add(jewlesArr[i]);
        }
        int l2 = stones.length();
        for (int i = 0; i < l2; i++) {
            if(jewSet.contains(stonesArr[i])) {
                ans++;
            }
        }
        return ans;
    }


}
