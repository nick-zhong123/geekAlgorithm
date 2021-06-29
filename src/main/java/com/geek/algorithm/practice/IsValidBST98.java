package com.geek.algorithm.practice;

import com.geek.algorithm.homework.TreeNode;

/**
 * @author nick
 * @date 2021/6/29 9:50 PM
 * @package com.geek.algorithm.practice
 * @description
 */
public class IsValidBST98 {


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     *
     * @param node
     * @param min
     * @param max
     * @return
     *
     */
    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.value <= min || node.value >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.value) && isValidBST(node.right, node.value, max);
    }
}
