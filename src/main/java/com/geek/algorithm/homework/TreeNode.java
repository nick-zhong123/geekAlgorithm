package com.geek.algorithm.homework;

/**
 *
 * @author nick
 * @date 2021/6/29 8:43 PM
 * @package com.geek.algorithm.homework
 * @description
 *   树节点
 *
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int value) { this.val = value;}
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.val = value;
        this.left = left;
        this.right = right;
    }

}
