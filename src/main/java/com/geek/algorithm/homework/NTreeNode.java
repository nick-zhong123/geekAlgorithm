package com.geek.algorithm.homework;

import com.geek.algorithm.practice.PreOrder589;

import java.util.List;

/**
 * @author nick
 * @date 2021/7/3 11:14 AM
 * @package com.geek.algorithm.homework
 * @description
 */
public class NTreeNode {

    public int val;
    public List<NTreeNode> children;

    public NTreeNode () {}

    public NTreeNode (int _val) {
        this.val = _val;
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        this.val = _val;
        this.children = _children;
    }

}
