package com.geek.algorithm.homework.week8;

/**
 *
 *
 * 58. 最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word/
 *
 *
 */
public class LengthOfLastWord58 {

    public int lengthOfLastWord(String s) {
        String ns = s.trim();
        int n = ns.length();
        char[] arr = ns.toCharArray();
        int l = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                break;
            }
            l++;
        }
        return l;
    }

}
