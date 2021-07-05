package com.geek.algorithm.practice;

import com.geek.algorithm.homework.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author nick
 * @date 2021/7/4 5:23 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *  236. 二叉树的最近公共祖先
 *  https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 */
public class LowestCommonAncestor236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        fathers = new HashMap<>();
        Set<Integer> redNodes = new HashSet<>();
        calFather(root);
        while(p != null) {
            redNodes.add(p.val);
            p = fathers.get(p.val);
        }
        while(!redNodes.contains(q.val)) {
            q = fathers.get(q.val);
        }

        return q;
    }

    /**
     *
     * 递归计算父亲节点
     *
     * @param root
     */
    public void calFather(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            fathers.put(root.left.val, root);
            calFather(root.left);
        }
        if (root.right != null) {
            fathers.put(root.right.val, root);
            calFather(root.right);
        }
    }

    private Map<Integer, TreeNode> fathers;

    /**
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        //         3
        //     /       \
        //    5         1
        //   / \       / \
        //  6   2     0   8
        //     / \
        //    7   4

        // node3是root
        // level 1
        node3.left = node5;
        node3.right = node1;
        // level2
        node5.left = node6;
        node5.right = node2;

        node1.left = node0;
        node1.right = node8;

        node2.left = node7;
        node2.right = node4;

        LowestCommonAncestor236 lowestCommonAncestor236 = new LowestCommonAncestor236();
        // 5 和 1 的祖先是3
        TreeNode lca1 = lowestCommonAncestor236.lowestCommonAncestor(node3, node5, node1);
        System.out.println("node 5,1, lca:" + lca1.val);
        // 5 和 5 的祖先是5
        TreeNode lca4 = lowestCommonAncestor236.lowestCommonAncestor(node3, node5, node4);
        System.out.println("node 5,4, lca:" + lca4.val);
    }
}
