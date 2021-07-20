package com.geek.algorithm.homework.week5;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

/**
 *
 * @author nick
 * @date 2021/7/20 9:31 PM
 * @package com.geek.algorithm.homework.week5
 * @description
 *   911. 在线选举
 *   https://leetcode-cn.com/problems/online-election/
 *
 *
 */
public class OnlineElection911 {

    private int[] maxPerson;
    private int[] persons;
    private int[] times;

    public OnlineElection911(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        this.maxPerson = new int[persons.length];
        // 统计各个候选人得票次数
        int[] count = new int[persons.length + 1];
        // 当前获胜者的编号
        int curPerson = persons[0];
        int maxCount = 1;
        for (int i = 0; i < persons.length; i++) {
            count[persons[i]]++;
            // 找到了票数最多的人
            if (count[persons[i]] >= maxCount) {
                curPerson = persons[i];
                maxCount = count[persons[i]];
            }
            // 在从下标0到i这一堆人中，目前curPerson获胜
            maxPerson[i] = curPerson;
        }
    }

    public int q(int t) {
        int left = 0;
        int right = times.length - 1;
        while (left < right) {
            int mid = (right + left) >> 1;
//            System.out.println("right:" + right + ", right:" + right + ", mid:" + mid);
            if (times[mid] > t) {
                right = mid;
            } else if (times[mid] < t) {
                left = mid + 1;
            } else {
                left = mid;
                break;
            }
        }
        if(t<times[left]){
            left-=1;
            if(left<0){
                left = 0;
            }
        }
        return  maxPerson[left];
    }

    public static void main(String[] args) {
        int[] persons = new int[] {0,1,1,0,0,1,0};
        int[] times = new int[] {0,5,10,15,20,25,30};
        OnlineElection911 action = new OnlineElection911(persons, times);
//        action.q(3);
//        action.q(12);
//        action.q(25);
//        action.q(15);
        action.q(24);
//        action.q(8);

    }

}
