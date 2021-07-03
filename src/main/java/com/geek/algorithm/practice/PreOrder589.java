package com.geek.algorithm.practice;

import java.util.ArrayList;
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


    /**
     *
     * 迭代前序遍历
     *
     * @param root
     * @return
     */
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

    private List<Integer> ans = new ArrayList<>();

    /**
     *
     * 递归
     * 输入：root = [1,null,3,2,4,null,5,6]
     * 输出：[1,3,5,6,2,4]
     */
    public void preOrderRecur(Node root) {
        ans = new ArrayList<>();
        subPreOrderRecur(root);
    }

    /**
     *
     *
     * 递归子方法
     *
     * @param root
     */
    public void subPreOrderRecur(Node root) {
        if (root == null) return;
        ans.add(root.val);
        if (root.children == null || root.children.isEmpty()) {
            return;
        }
        for (Node child : root.children) {
            subPreOrderRecur(child);
        }
    }

    /**
     * 589. N 叉树的前序遍历
     * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
     * @param args
     */
    public static void main(String[] args) {
        Node node1 = new Node(1);
        // 第三层
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        // 第二层
        Node node3 = new Node(3);
        List<Node> children3 = new ArrayList<>();
        children3.add(node5);
        children3.add(node6);
        node3.children = children3;

        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> children1 = new ArrayList<>();
        children1.add(node3);
        children1.add(node2);
        children1.add(node4);
        node1.children = children1;

        PreOrder589 preOrder589 = new PreOrder589();
        preOrder589.preOrderRecur(node1);

        System.out.println("589. N 叉树的前序遍历, result:{}" + preOrder589.ans.toString());

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
