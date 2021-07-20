package com.geek.algorithm.homework.week5;

import java.util.Arrays;

/**
 *
 *
 * @author nick
 * @date 2021/7/20 8:51 PM
 * @package com.geek.algorithm.homework.week5
 * @description
 *
 * 1011. 在 D 天内送达包裹的能力
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 *
 */
public class CapacityToShipPackagesWithIndDays1011 {


    public int shipWithinDays(int[] weights, int days) {
        // 确定二分查找左右边界
        // 对于左边界而言，由于我们不能「拆分」一个包裹，因此船的运载能力不能小于所有包裹中最重的那个的重量，
        // 即左边界为数组weights中元素的最大值。
        // 对于右边界而言，船的运载能力也不会大于所有包裹的重量之和，即右边界为数组weights中元素的和。
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while(left < right) {
            int mid = (left + right) / 2;
            int cur = 0;
            int needDay = 1;
            System.out.println("mid=" + mid + ", left:" + left + ", right=" + right);
            for(int weight : weights) {
                System.out.println("mid=" + mid + ", weight:" + weight + ", cur=" + cur + ", needDay:" + needDay);
                if (cur + weight > mid) {
                    needDay++;
                    cur = 0;
                }
                cur += weight;
            }
            System.out.println("needDay:" + needDay);
            if (needDay <= days) {
               right = mid;
            } else {
               left = mid + 1;
            }
        }
        System.out.println("left:" + left + ", right=" + right);
        return left;
    }

    public static void main(String[] args) {

        CapacityToShipPackagesWithIndDays1011 action = new CapacityToShipPackagesWithIndDays1011();

        System.out.println("------------------------");
        int[] ws1 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int d1 = 5;
        action.shipWithinDays(ws1, d1);

        System.out.println("------------------------");
        int[] ws2 = new int[]{3,2,2,4,1,4};
        int d2 = 3;
        action.shipWithinDays(ws2, d2);

        System.out.println("------------------------");
        int[] ws3 = new int[]{1,2,3,1,1};
        int d3 = 4;
        action.shipWithinDays(ws3, d3);
        System.out.println("------------------------");

    }
}
