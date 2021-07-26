package com.geek.algorithm.practice;


import com.sun.tools.javac.util.Pair;
import sun.awt.geom.AreaOp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MiGong {


    boolean hasPath(List<List<Integer>> maze, List<Integer> start, List<Integer> destination) {
        int m = maze.size();
        int n = maze.get(0).size();
        boolean[][] visited = new boolean[m][n];
        // 省略了destination是否能停止的判断
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(start.get(0), start.get(1)));
        visited[start.get(0)][start.get(1)] = true;
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.poll();
            int x = node.fst;
            int y = node.snd;
            if (x == destination.get(0) && y == destination.get(1)) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 一直走，直到遇到障碍物或越界为止
                while(nx >= 0 && ny >= 0 && nx < m && ny < n
                        && maze.get(nx).get(ny) == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                if (x != nx || y != ny) {
                    queue.offer(new Pair<>(nx, ny));
                }
            }
        }
        return false;
    }

    private int[] dx = new int[] {-1, 0, 0, 1};
    private int[] dy = new int[] {0, -1, 1, 0};

    public static void main(String[] args) {
        List<List<Integer>> maze = new ArrayList<List<Integer>>(){{
            add(Arrays.asList(0,0,1,0,0));
            add(Arrays.asList(0,0,0,0,0));
            add(Arrays.asList(0,0,0,1,0));
            add(Arrays.asList(1,1,0,1,1));
            add(Arrays.asList(0,0,0,0,0));
        }};
        List<Integer> start = Arrays.asList(0, 4);
        List<Integer> destination = Arrays.asList(4, 4);
        MiGong miGong = new MiGong();
        boolean result = miGong.hasPath(maze, start, destination);
        System.out.println("result:" + result);

    }



}
