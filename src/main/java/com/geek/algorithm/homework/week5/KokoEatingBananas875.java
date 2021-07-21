package com.geek.algorithm.homework.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nick
 * @date 2021/7/21 8:53 PM
 * @package com.geek.algorithm.homework.week5
 * @description
 *
 *  875. 爱吃香蕉的珂珂
 *  https://leetcode-cn.com/problems/koko-eating-bananas/
 *
 */
public class KokoEatingBananas875 {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while(left < right) {
            int needHour = 0;
            int mid = left + ((right - left) >> 1);
            for (int pile : piles) {
//                System.out.println("left:" + left + ", right:" + right + ", mid:" + mid + ", needHour:" + needHour);
                needHour += (pile + mid - 1) / mid; // 向上取整
            }
            System.out.println("left:" + left + ", right:" + right + ", mid:" + mid + ", needHour:" + needHour);
//            if (needHour == h) {
//                left = mid;
//                break;
//            }
            // 注意这里是小于等于
            if (needHour <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("left:" + left);
        return left;
    }

    public static void main(String[] args) {
        KokoEatingBananas875 action = new KokoEatingBananas875();

        // 示例 1：
        // 输入: piles = [3,6,7,11], H = 8
        // 输出: 4
        int[] piles1 = new int[]{3,6,7,11};
        int h1 = 8;
        action.minEatingSpeed(piles1, h1);

        // 示例2：
        // 输入: piles = [30,11,23,4,20], H = 5
        // 输出: 30
        int[] piles2 = new int[]{30,11,23,4,20};
        int h2 = 5;
        action.minEatingSpeed(piles2, h2);

        // 示例3：
        // 输入: piles = [30,11,23,4,20], H = 6
        // 输出: 23
        int[] piles3 = new int[]{30,11,23,4,20};
        int h3 = 6;
        action.minEatingSpeed(piles3, h3);
    }

}
