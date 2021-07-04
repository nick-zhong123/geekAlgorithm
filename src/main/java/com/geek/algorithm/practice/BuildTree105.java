package com.geek.algorithm.practice;

import com.geek.algorithm.homework.TreeNode;

/**
 * @author nick
 * @date 2021/7/3 5:10 PM
 * @package com.geek.algorithm.homework.week3
 * @description
 *
 *
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTree105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int l1, int r1, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        int mid = l2;
        while(preorder[l1] != inorder[mid]) mid++;
        root.left = build(l1 + 1, l1 + mid - l2, l2, mid - 1);
        root.right = build(l1 + mid - l2 + 1, r1, mid + 1, r2);
        return root;
    }

    private int[] preorder;
    private int[] inorder;

    public static void main(String[] args) {
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node9 = new TreeNode(9);
//        TreeNode node20 = new TreeNode(20);
//        TreeNode node15 = new TreeNode(15);
//        TreeNode node7 = new TreeNode(7);

        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        BuildTree105 buildTree105 = new BuildTree105();
        TreeNode root = buildTree105.buildTree(preorder, inorder);
        System.out.println("root:" + root);

    }
}
