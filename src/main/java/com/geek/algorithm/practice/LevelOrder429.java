package com.geek.algorithm.practice;

import com.geek.algorithm.homework.NTreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author nick
 * @date 2021/7/3 11:10 AM
 * @package com.geek.algorithm.practice
 * @description
 *
 *   429 N叉树的层序遍历
 *      https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 */
public class LevelOrder429 {

    /**
     *
     *
     * @param root
     * @return
     *
     */
    public List<List<Integer>> levelOrder(NTreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair<NTreeNode, Integer>> stack = new LinkedList<>();
        stack.add(new Pair<>(root, 0));
        while(!stack.isEmpty()) {
            Pair<NTreeNode, Integer> pair = stack.poll();
            if (pair == null) break;
            NTreeNode node = pair.getKey();
            if (node == null) break;
            Integer nodeDepth = pair.getValue();
            if (ans.size() <= nodeDepth) {
                ans.add(new ArrayList<>());
            }
            ans.get(nodeDepth).add(node.val);
            for (NTreeNode child : node.children) {
                stack.add(new Pair<>(child, nodeDepth + 1));
            }
        }
        return ans;
    }

}
