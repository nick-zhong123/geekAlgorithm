package com.geek.algorithm.practice;


import java.util.*;

/**
 *
 * 212. 单词搜索 II
 * https://leetcode-cn.com/problems/word-search-ii/
 *
 */
public class WordSearchII {

    private class TrieNode {
        private int path;
        private int end;
        private String word;
        private Map<Character, TrieNode> next;

        public TrieNode() {
            path = 0;
            end = 0;
            word = "";
            next = new HashMap<Character, TrieNode>();
        }

    }

    private TrieNode root;

    private void insert(String word) {
        if (word == null || word == "") return;
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) {
                node.next.put(ch, new TrieNode());
            }
            node.path++;
            node = node.next.get(ch);
        }
        node.end++;
        node.word = word;
    }

    private boolean search(String word) {
        if (word == null || word == "") return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) {
                return false;
            }
            node = node.next.get(ch);
        }
        if (node.end > 0) return true;
        return false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();
        root = new TrieNode();
        for(String word : words) {
            insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, root, ans, i, j);
            }
        }
        return new ArrayList<String>(ans);
    }

    int[][] director = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs (char[][] board, TrieNode now, Set<String> ans, int i1, int j1) {
        char ch = board[i1][j1];
        if (!now.next.containsKey(ch)) {
            return;
        }
        now = now.next.get(ch);
        if (now.word != "") {
            ans.add(now.word);
        }
        board[i1][j1] = '#';
        for(int[] dir : director) {
            int ni = i1 + dir[0];
            int nj = j1 + dir[1];
            if (ni < 0 || nj < 0 || ni >= board.length || nj >= board[0].length) {
                continue;
            }
            dfs(board, now, ans, ni, nj);
        }
        board[i1][j1] = ch;
    }

}
