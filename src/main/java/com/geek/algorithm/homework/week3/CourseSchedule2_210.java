package com.geek.algorithm.homework.week3;

import java.util.*;

/**
 *
 * @author nick
 * @date 2021/7/5 9:35 PM
 * @package com.geek.algorithm.homework.week3
 * @description
 *
 *   210. 课程表 II
 *   https://leetcode-cn.com/problems/course-schedule-ii/
 *
 */
public class CourseSchedule2_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        order = new int[numCourses];
        inDegree = new int[numCourses];
        // 初始化数据
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
            inDegree[i] = 0;
        }
        // 加边
        for (int[] edge : prerequisites) {
            addEdge(edge);
        }
        topsort(edges, numCourses);
        return order;
    }

    // 拓扑排序
    public void topsort(List<List<Integer>> edges, int numCourses) {
        Queue<Integer> queue = new LinkedList<>();
        // 寻找入度为零的点
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                // 注意入对尾
                queue.offer(i);
            }
        }
        int orderIndex = 0;
        while(!queue.isEmpty()) {
            int x = queue.poll();
            // 将x加入前提课程
            order[orderIndex++] = x;
            for (int y : edges.get(x)) {
                inDegree[y]--;
                if (inDegree[y] == 0) queue.offer(y);
            }
        }
    }

    private void addEdge(int[] edge) {
        edges.get(edge[1]).add(edge[0]);
        inDegree[edge[0]]++;
    }

    // 返回的课程顺序
    private int[] order;
    // 入度
    private int[] inDegree;
    // 入度边
    private List<List<Integer>> edges;

    public  static void main(String[] args) {
        int[][] prerequisites = new int[][]{{2,0}, {1,0}, {3,1}, {3,2}};
        int num = 4;
        CourseSchedule2_210 courseSchedule2_210 = new CourseSchedule2_210();
        int[] result = courseSchedule2_210.findOrder(num, prerequisites);
        System.out.println("210. 课程表 II, result:" + Arrays.toString(result));
    }
}
