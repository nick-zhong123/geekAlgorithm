package com.geek.algorithm.homework.week2;

import com.geek.algorithm.homework.TreeNode;

/**
 * @author nick
 * @date 2021/6/29 8:49 PM
 * @package com.geek.algorithm.homework.week2
 * @description
 */
public class InvertTree226 {

    /**
     *
     * 翻转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}