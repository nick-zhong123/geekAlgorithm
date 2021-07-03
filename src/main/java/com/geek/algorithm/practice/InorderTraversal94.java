package com.geek.algorithm.practice;

import com.geek.algorithm.homework.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nick
 * @date 2021/7/3 10:00 AM
 * @package com.geek.algorithm.practice
 * @description
 *
 */
public class InorderTraversal94 {

    private List<Integer> ans;

    public List<Integer> inorderTraversal(TreeNode root) {
       ans = new ArrayList<>();
       inorders(root);
       return ans;
    }

    private void inorders(TreeNode root) {
        if (root == null) {
            return;
        }
        inorders(root.left);
        ans.add(root.val);
        inorders(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        InorderTraversal94 inorderTraversal94 = new InorderTraversal94();
        List<Integer> result = inorderTraversal94.inorderTraversal(node1);
        System.out.println("中序遍历, result:{}" + result.toString());
    }

}
