package com.geek.algorithm.homework.week8;

public class ToLowerCase709 {


    /**
     *  709. 转换成小写字母
     *  https://leetcode-cn.com/problems/to-lower-case/
     *
     * @param s
     * @return
     */
    public String toLowerCase(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] > 'A' && arr[i] < 'Z') {
                ans[i] = (char) (arr[i] - 'A' + 'a');
            } else {
                ans[i] = arr[i];
            }
        }

        return new String(ans);
    }

    public static void main(String[] args) {
        ToLowerCase709 action = new ToLowerCase709();
        String s = "Hello";
        action.toLowerCase(s);
    }


}
