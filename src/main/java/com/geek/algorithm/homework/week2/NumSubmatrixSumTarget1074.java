package com.geek.algorithm.homework.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nick
 * @date 2021/6/27 5:47 PM
 * @package com.geek.algorithm.homework.week2
 * @description
 *
 *   1074. 元素和为目标值的子矩阵数量
 *   https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/
 *
 *   输入：matrix = [[1,-1],[-1,1]], target = 0
 *   输出：5
 *   解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class NumSubmatrixSumTarget1074 {

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        // 求解二维前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] + matrix[i - 1][j - 1] - pre[i - 1][j - 1];
            }
        }

        int ans = 0;
        for (int up = 1; up <= m; up++) {           // up为矩形上边界
            for (int down = up; down <= m; down++) { // down为矩形下边界
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int cur = 0;
                for (int i = 1; i <= n; i++) {      // i是这一行的第i个元素
                    cur = pre[down][i] - pre[up - 1][i];
                    ans += map.getOrDefault(cur - target, 0);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums0 = {
                {1,-1},
                {-1,1}
        };
        int target0= 0;
        System.out.println("1, right result 5, ans:" + numSubmatrixSumTarget(nums0, target0));



        int[][] nums1 = {
                {0,1,0},
                {1,1,1},
                {0,1,0}
        };
        int target1 = 0;
        System.out.println("2, right result 4, ans:" + numSubmatrixSumTarget(nums1, target1));

        int[][] nums2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int target2 = 6;
        System.out.println("3, right result 2, ans:" + numSubmatrixSumTarget(nums2, target2));
    }
}
