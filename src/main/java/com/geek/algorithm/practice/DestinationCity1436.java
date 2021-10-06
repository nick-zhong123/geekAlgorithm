package com.geek.algorithm.practice;

import java.util.*;

public class DestinationCity1436 {

    /**
     * 1436. 旅行终点站
     * https://leetcode-cn.com/problems/destination-city/
     *
     * @param paths
     * @return
     */
    public String destCity(List<List<String>> paths) {
        Map<String, List<String>> links = new HashMap<>();
        for (List<String> path : paths) {
            String start = path.get(0);
            String end = path.get(0);
            if (!links.containsKey(start)) {
                List<String> children = new ArrayList<>();
                links.put(start, children);
            }
            if (!links.containsKey(end)) {
                List<String> children = new ArrayList<>();
                links.put(end, children);
            }
            List<String> children = links.get(start);
            children.add(end);
        }
        for (Map.Entry<String, List<String>> entry : links.entrySet()) {
            if (entry.getValue().isEmpty()) {
                return entry.getKey();
            }
        }
        return "";
    }

    public String destCity1(List<List<String>> paths) {
        Set<String> cityA = new HashSet<>();
        for (List<String> path : paths) {
            cityA.add(path.get(0));
        }
        for (List<String> path: paths) {
            if (!cityA.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }

}