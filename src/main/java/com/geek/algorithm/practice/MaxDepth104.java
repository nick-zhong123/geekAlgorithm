package com.geek.algorithm.practice;

import com.geek.algorithm.homework.TreeNode;

/**
 *
 * @author nick
 * @date 2021/6/29 10:35 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *
 */
public class MaxDepth104 {

    public int maxDepth(TreeNode root) {
        return  maxDepth(root, 1);
    }

    public int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = maxDepth(root.left, depth + 1);
        int rightDepth = maxDepth(root.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }

}
