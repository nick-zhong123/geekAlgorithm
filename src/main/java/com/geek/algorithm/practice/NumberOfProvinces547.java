package com.geek.algorithm.practice;

import java.util.HashMap;
import java.util.Map;

public class NumberOfProvinces547 {

    private final Map<Integer, Integer> father = new HashMap<>();
    private int countSet = 0;

    public void add(int x) {
        if (!father.containsKey(x)) {
            father.put(x, null);
            countSet++;
        }
    }

    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            father.put(rootX, rootY);
            countSet--;
        }
    }

    public int find(int x) {
        int root = x;
        while(father.get(root) != null) {
            root = father.get(root);
        }
        while(x != root) {
            int origin_father = father.get(x);
            father.put(x, root);
            x = origin_father;
        }
        return root;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getNums() {
        return countSet;
    }

    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        for(int i = 0; i < m; i++) {
            add(i);
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    merge(i, j);
                }
            }
        }
        return countSet;
    }

}
