package com.geek.algorithm.practice;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author nick
 * @date 2021/7/9 10:13 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *
 *  200. 岛屿数量
 *     https://leetcode-cn.com/problems/number-of-islands/
 *
 */
public class NumberOfIslands200_bfs {


    /**
     *
     *
     *
     * @param grid
     * @return
     *
     */
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     *
     * @param x
     * @param y
     */
    private void bfs(char[][] grid, int x, int y) {
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        // 第一步：push起点
        queue.offer(new Pair<>(x, y));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int sx = queue.peek().getKey();
            int sy = queue.poll().getValue();
            // 扩展所有出边（四个方向）
            for (int i = 0; i < 4; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];
                // 越界判断
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (grid[nx][ny] == '1' && !visited[nx][ny]) {
                    queue.offer(new Pair<>(nx, ny));
                    // BFS：入队时标记visit
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private int m;
    private int n;
    private boolean[][] visited;

    public static void main(String[] args) {
        char[][] grid1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}
        };
        NumberOfIslands200_bfs numberOfIslands200BFS = new NumberOfIslands200_bfs();
        int ans = numberOfIslands200BFS.numIslands(grid1);
        System.out.println("islands num:" + ans);
    }

}