package com.geek.algorithm.common;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 并查集基本操作
 *
 */
public class UnionFind {

    private Map<Integer, Integer> father;

    public UnionFind() {
        father = new HashMap<>();
    }

    public void add(int x) {
        if (!father.containsKey(x)) {
            father.put(x, null);
        }
    }

    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            father.put(rootX, rootY);
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
}
