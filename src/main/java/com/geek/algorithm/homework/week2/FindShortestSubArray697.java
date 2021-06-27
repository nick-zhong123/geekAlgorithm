package com.geek.algorithm.homework.week2;

import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nick
 * @date 2021/6/27 10:04 AM
 * @package com.geek.algorithm.homework.week2
 * @description
 *
 * 697. 数组的度
 *  https://leetcode-cn.com/problems/degree-of-an-array/
 */
public class FindShortestSubArray697 {

    /**
     *
     * 第一次没有看答案，依据老师上课讲的HASH方法，完成题目
     * 虽然是简单题， 但是开心😄
     * @param nums
     * @return
     */
    public static int findShortestSubArray(int[] nums) {
        // 计算每个整数出现的频次、初始索引、结束索引
        Map<Integer, Node> map = new HashMap<>();
        int n = nums.length;
        // 存储最大的数组度
        int maxDepth = 0;
        // 结果值
        Node result = new Node();
        // 计算数组的度
        for (int i = 0; i < n; i++) {
            // 第一次出现要new
            if (!map.containsKey(nums[i])) {
                Node node = new Node(i, i, 0);
                map.put(nums[i], node);
            }
            Node node = map.get(nums[i]);
            // 度数加1
            node.depth++;
            // 更新结束边界
            node.j = i;
        }
        for (int i = 0; i < n; i++) {
            Node node = map.get(nums[i]);
            // 1.如果新整数度数更大
            // 2.如果度数相同，更新距离更短度值
            if (maxDepth < node.depth ||
                    (maxDepth == node.depth && ((result.j - result.i) > (node.j - node.i)))) {
                result = node;
                maxDepth = node.depth;
                System.out.println("compute, maxDepth:" + maxDepth + ", start:" + result.i + ", end:" + result.j);
            }
        }
        System.out.println("result, maxDepth:" + maxDepth + ", start:" + result.i + ", end:" + result.j);
        return result.j - result.i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2, 3, 1};
        findShortestSubArray(nums);
    }

    public static class Node {
        // 初始索引
        public int i = 0;
        // 结束索引
        public int j = 0;
        // 频次/数组度
        public int depth = 0;

        public Node () {}
        public Node (int i, int j, int depth) {
            this.i = i;
            this.j = j;
            this.depth = depth;
        }
    }

}
