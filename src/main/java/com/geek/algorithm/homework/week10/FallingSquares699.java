package com.geek.algorithm.homework.week10;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * 699. 掉落的方块
 *
 *  https://leetcode-cn.com/problems/falling-squares/
 *
 */
public class FallingSquares699 {

    /**
     * 方法一：模拟方块掉落
     * 思路
     *
     * 不要思考“哪个方块影响次此位置的高度？”，应该思考“一个方块影响哪些位置的高度？”。
     *
     * @param positions
     * @return
     */
    public List<Integer> fallingSquares1(int[][] positions) {
        int[] qans = new int[positions.length];
        // 索引位置i只能递增计算
        for (int i = 0; i < positions.length; i++) {
            int left = positions[i][0];
            int size = positions[i][1];
            int right = left + size;
            qans[i] += size;

            for (int j = i+1; j < positions.length; j++) {
                int left2 = positions[j][0];
                int size2 = positions[j][1];
                int right2 = left2 + size2;
                if (left2 <= right && left <= right2) { //intersect
                    qans[j] = Math.max(qans[j], qans[i]);
                }
            }
        }

        List<Integer> ans = new ArrayList();
        int cur = -1;
        for (int x: qans) {
            cur = Math.max(cur, x);
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] postions = new int[4][2];
        postions[0][0] = 1;
        postions[0][1] = 2;

        postions[1][0] = 2;
        postions[1][1] = 1;

        postions[2][0] = 4;
        postions[2][1] = 5;

        postions[3][0] = 6;
        postions[3][1] = 1;

        FallingSquares699 action = new FallingSquares699();
        List<Integer> list = action.fallingSquares1(postions);
        System.out.println("" + list.toString());
    }

}
