package com.geek.algorithm.practice;

import com.geek.algorithm.homework.TreeNode;

/**
 * @author nick
 * @date 2021/6/29 10:48 PM
 * @package com.geek.algorithm.practice
 * @description
 *  111.二叉树的最小深度
 *      https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 */
public class MinDepth111 {

    /**
     *
     * @param root
     * @return
     *
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }

}
