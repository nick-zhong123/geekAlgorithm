package com.geek.algorithm.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nick
 * @date 2021/7/4 10:17 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *  684. 冗余连接
 *  https://leetcode-cn.com/problems/redundant-connection/description/
 *
 */
public class RedundantConnection684 {

    public int[] findRedundantConnection(int[][] input) {
        edges = new ArrayList<>();
        // 找最大的n
        n = 0;
        for (int[] edge : input) {
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        }
        // 初始化边
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            visited[i] = false;
            edges.add(new ArrayList<>());
        }
        hasCycle = false;

        // 加边
        for (int[] edge : input) {
            int u = edge[0];
            int v = edge[1];
            addEdge(u,v);
            addEdge(v,u);
            for (int i = 0; i <= n; i++) visited[i] = false;
            dfs(u, -1);
            if (hasCycle) return edge;
        }
        return null;
    }

    private void dfs(int x, int fa) {
        // 标记已经访问
        visited[x] = true;
        for (int y : edges.get(x)) {
            if (y == fa) continue;
            if (visited[y]) hasCycle=true;
            else dfs(y, x);
        }
    }

    /**
     * 加边
     * @param u
     * @param v
     */
    private void addEdge(int u, int v) {
        edges.get(u).add(v);
    }

    private int n;
    private List<List<Integer>> edges;
    private boolean[] visited;
    private boolean hasCycle;
}
