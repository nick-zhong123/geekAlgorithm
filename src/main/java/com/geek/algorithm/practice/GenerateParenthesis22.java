package com.geek.algorithm.practice;

import java.util.*;

/**
 *
 * @author nick
 * @date 2021/7/1 9:42 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *
 */
public class GenerateParenthesis22 {


    public List<String> generateParenthesis(int n) {
        return null;
    }

    public List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
            return result;
        }
        if (cache.containsKey(n)) return cache.get(n);
        for (int k = 1; k <= n; k++) {
            List<String> left = generate(k - 1);
            List<String> right = generate( n - k);
            for (String l : left) {
                for (String r : right) {
                    result.add(new StringBuilder("(")
                            .append(l)
                            .append(")")
                            .append(r)
                            .toString());
                }
            }
        }
        cache.put(n, result);
        return result;
    }


    private Map<Integer, List<String>> cache = new HashMap<>();

    public static void main (String[] args) {
        GenerateParenthesis22 gen = new GenerateParenthesis22();
        int n = 3;
        List<String> result = gen.generate(n);
        System.out.println("result:" + result);
    }

}
