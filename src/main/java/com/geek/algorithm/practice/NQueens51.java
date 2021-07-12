package com.geek.algorithm.practice;

import java.util.*;

/**
 *
 * @author nick
 * @date 2021/7/11 2:24 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *
 * 51. N 皇后
 *    https://leetcode-cn.com/problems/n-queens/
 *
 */
public class NQueens51 {

    public List<List<String>> solveNQueens(int n) {
        usedIPlusJ = new HashSet<>();
        usedIMinusJ = new HashSet<>();
        used = new HashSet<>();
        ans = new ArrayList<>();
        perResult = new LinkedList<>();
        this.n = n;
        find(0);
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> row : ans) {
            List<String> rowValue = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Integer col = row.get(i);
                StringBuilder colValue = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == col) {
                        colValue.append("Q");
                    } else {
                        colValue.append(".");
                    }
                }
                rowValue.add(colValue.toString());
            }
            result.add(rowValue);
        }
        return result;
    }

    private void find(int row) {
        if (row == n) {
            ans.add(new ArrayList<>(perResult));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!used.contains(col) &&
                    !usedIMinusJ.contains(row - col) &&
                    !usedIPlusJ.contains(row + col)) {
                used.add(col);
                usedIMinusJ.add(row - col);
                usedIPlusJ.add(row + col);
                perResult.offer(col);
                find(row + 1);
                perResult.poll();
                usedIPlusJ.remove(row + col);
                usedIMinusJ.remove(row - col);
                used.remove(col);
            }
        }

    }

    private int n;
    private Set<Integer> usedIPlusJ;
    private Set<Integer> usedIMinusJ;
    private Set<Integer> used;
    private List<List<Integer>> ans;
    private LinkedList<Integer> perResult;

    public static void main(String[] args) {
        int n = 5;
        NQueens51 nQueens51 = new NQueens51();
        List<List<String>> result = nQueens51.solveNQueens(n);
        System.out.println("N 皇后:" + result.toString());
    }

}
