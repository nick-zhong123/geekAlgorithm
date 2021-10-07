package com.geek.algorithm.practice;

import java.util.LinkedList;

/**
 *
 * 130. 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 */
public class SurroundedRegions130 {

    int n;
    int m;

    /**
     *
     * 深度优先解法
     *
     * @param board
     */
    public void solveDfs(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        // 边长设置为'A'
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n -1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public void solveBfs(char[][] board) {
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        n = board.length;
        m = board[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            if (board[i][m-1] == 'O') {
                queue.offer(new int[]{i, m-1});
            }
        }
        for (int i = 1; i < m -1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
            }
            if (board[n-1][i] == 'O') {
                queue.offer(new int[]{n-1, i});
            }
        }
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            board[x][y] = 'A';
            for (int i = 0; i < 4; i++) {
                int mX = x + dx[i];
                int mY = y + dy[i];
                if (mX < 0 || mY < 0 || mX >= n || mY >= m || board[mX][mY] != 'O') {
                    continue;
                }
                board[mX][mY] = 'A';

                queue.offer(new int[]{mX, mY});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

}
