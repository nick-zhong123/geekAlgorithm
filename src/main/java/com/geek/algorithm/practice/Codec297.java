package com.geek.algorithm.practice;

import com.geek.algorithm.homework.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nick
 * @date 2021/7/3 3:00 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 *  297. 二叉树的序列化与反序列化
 *  https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec297 {

    /**
     *
     * 输入：root = [1,2,3,null,null,4,5]
     * 输出：[1,2,3,null,null,4,5]
     *
     * 输入：root = []
     * 输出：[]
     *
     * 输入：root = [1]
     * 输出：[1]
     *
     * 输入：root = [1,2]
     * 输出：[1,2]
     *
     *
     * @param root
     * @return
     *
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        seq = new ArrayList<>();
        subSerialize(root);
        return seq.toString();
    }

    private void subSerialize(TreeNode root) {
        if (root == null) {
            seq.add("null");
            return;
        }
        seq.add(root.val + "");
        subSerialize(root.left);
        subSerialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        deq = Arrays.asList(data.split(" "));
        cur = -1;
        TreeNode root = cal();
        System.out.println("反序列化成功");
        return root;
    }

    public TreeNode cal() {
        cur++;
        if (deq.get(cur).equals("null")) {
            return null;
        }
        int val = Integer.parseInt(deq.get(cur));
        TreeNode treeNode = new TreeNode(val);
        treeNode.left = cal();
        treeNode.right = cal();
        return treeNode;
    }

    private List<String> seq;
    private List<String> deq;
    private int cur;

    public static void main(String[] args) {
        // 序列化
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        Codec297 ser = new Codec297();
        // 序列化：[1, 2, null, null, 3, 4, null, null, 5, null, null]
        System.out.println("序列化：" + ser.serialize(node1));

        Codec297 dec = new Codec297();
        String data = "1 2 3 null null 4 5";
        System.out.println("反序列化：" + dec.deserialize(data));
    }


}
