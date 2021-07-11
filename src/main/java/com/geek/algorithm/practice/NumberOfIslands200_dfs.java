package com.geek.algorithm.practice;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author nick
 * @date 2021/7/7 10:26 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *  200. 岛屿数量
 *     https://leetcode-cn.com/problems/number-of-islands/
 *
 *
 *
 */
public class NumberOfIslands200_dfs {

    /**
     *
     * @param grid
     * @return
     *
     */
    public int numIslands(char[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        // 初始化未被访问的数据
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        //
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // grid
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int sx, int sy) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(sx, sy));
        visited[sx][sy] = true;
        while(!queue.isEmpty()) {
            int x = queue.peek().getKey();
            int y = queue.poll().getValue();
            // 扩展四个出边
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (grid[nx][ny] == '1' && !visited[nx][ny]) {
                    Pair<Integer, Integer> pair = new Pair<>(nx, ny);
                    queue.offer(pair);
                    visited[nx][ny] = true;
                }
            }
        }

    }

    private int[] dx = {-1,0,0,1};
    private int[] dy = {0,1,-1,0};
    private boolean[][] visited;
    private int m;
    private int n;

    public static void main(String[] arsg) {
        char[][] grid1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        NumberOfIslands200_dfs numberOfIslands200Dfs = new NumberOfIslands200_dfs();
        int ans = numberOfIslands200Dfs.numIslands(grid1);
        System.out.println("islands num:" + ans);

    }


}
