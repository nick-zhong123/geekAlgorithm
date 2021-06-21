package com.geek.algorithm.practice;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nick
 * @date 2021/6/20 7:45 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *   https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 */
public class PreOrder589 {


    public List<Integer> preOrder(Node root) {
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            stack.addAll(node.children);
        }
        return output;
    }


    /**
     *
     * Node定义
     *
     */
    public static class Node {

        public int val;
        public List<Node> children;

        public Node () {}

        public Node (int _val) {
            this.val = _val;
        }

        public Node(int _val, List<Node> _children) {
            this.val = _val;
            this.children = _children;
        }

    }

}
