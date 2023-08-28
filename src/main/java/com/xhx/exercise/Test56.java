package com.xhx.exercise;

import org.junit.Test;

/**
 *849. 到最近的人的最大距离
 *
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 返回他到离他最近的人的最大距离。
 *
 * 输入：seats = [1,0,0,0,1,0,1]
 * 输出：2
 */
public class Test56 {
    @Test
    public void test(){
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }

    public int maxDistToClosest(int[] seats) {
        StringBuilder sb = new StringBuilder();
        for (int seat : seats) {
            sb.append(seat);
        }
        String seatStr = sb.toString();
        int res = 0;
        int begin = seatStr.indexOf("1");
        int last = seatStr.lastIndexOf("1");
        res = Math.max(res,begin);
        res = Math.max(res,seatStr.length()-last-1);
        if (begin == last){
            return res;
        }
        String substring = seatStr.substring(begin+1, last);
        int mid = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '0'){
                mid++;
            } else {
                if (mid%2 == 0){
                    res = Math.max(res,mid/2);
                } else {
                    res = Math.max(res,mid/2 + 1);
                }
                mid = 0;
            }
        }
        if (mid > 0){
            if (mid%2 == 0){
                res = Math.max(res,mid/2);
            } else {
                res = Math.max(res,mid/2 + 1);
            }
        }
        return res;
    }
}
