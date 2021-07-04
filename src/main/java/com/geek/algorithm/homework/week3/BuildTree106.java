package com.geek.algorithm.homework.week3;

import com.geek.algorithm.homework.TreeNode;

/**
 * @author nick
 * @date 2021/7/4 4:55 PM
 * @package com.geek.algorithm.homework.week3
 * @description
 *
 *    106. 从中序与后序遍历序列构造二叉树
 *    https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 */
public class BuildTree106 {

    /**
     *
     *
     *
     *
     * @param inorder
     * @param postorder
     * @return
     *
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0, inorder.length - 1, 0, postorder.length - 1);
    }

    /**
     *
     * inorder [9,3,15,20,7]
     * postorder [ 9,15,7,20,3]
     * postorder的最后一个值是root
     *
     *       3  mid = 1
     *     /   \
     *    9     15,20,7       20  mid = 3
     *    9     15,7,20      /   \
     *                      15    7
     *                      15    7
     *
     */


    /**
     * 1.后序遍历
     *  postorder最后一个值为root
     *
     * @return
     */
    public TreeNode build(int l1, int r1, int l2, int r2) {
        if (l1 > r1)
            return null;
        // 后序遍历，postorder最后一个值为root
        TreeNode root = new TreeNode(postorder[r2]);
        // mid, 从inorder中查找root的位置
        int mid = l1;
        while(postorder[r2] != inorder[mid]) mid++;
        root.left = build(l1, mid - 1, l2, l2 + mid - l1 - 1);
        root.right = build(mid + 1, r1, l2 + mid - l1, r2 -1);
        return root;
    }

    private int[] inorder;
    private int[] postorder;

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        BuildTree106 buildTree106 = new BuildTree106();
        TreeNode root = buildTree106.buildTree(inorder, postorder);
        System.out.println("BuildTree106, root" + root);
    }

}
