package com.xhx.exercise;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1585
 * 给你两个字符串 s 和 t ，请你通过若干次以下操作将字符串 s 转化成字符串 t ：
 *
 * 选择 s 中一个 非空 子字符串并将它包含的字符就地 升序 排序。
 * 比方说，对下划线所示的子字符串进行操作可以由 "14234" 得到 "12344" 。
 *
 * 如果可以将字符串 s 变成 t ，返回 true 。否则，返回 false 。
 *
 * 一个 子字符串 定义为一个字符串中连续的若干字符。
 *
 * 示例 1：
 *
 * 输入：s = "84532", t = "34852"
 * 输出：true
 * 解释：你可以按以下操作将 s 转变为 t ：
 * "84532" （从下标 2 到下标 3）-> "84352"
 * "84352" （从下标 0 到下标 2） -> "34852"
 * 示例 2：
 *
 * 输入：s = "34521", t = "23415"
 * 输出：true
 * 解释：你可以按以下操作将 s 转变为 t ：
 * "34521" -> "23451"
 * "23451" -> "23415"
 * 示例 3：
 *
 * 输入：s = "12345", t = "12435"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "1", t = "2"
 * 输出：false
 * 提示：
 *
 * s.length == t.length
 * 1 <= s.length <= 105
 * s 和 t 都只包含数字字符，即 '0' 到 '9' 。
 */
public class Test18 {
    @Test
    public void test(){
        System.out.println(isTransformable("84532","34852"));
        System.out.println(isTransformable("12345","12435"));
    }

    public boolean isTransformable(String s, String t) {
        int n = s.length();
        Queue<Integer>[] queueArr = new Queue[10];
        for (int i = 0; i < 10; i++) {
            queueArr[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            queueArr[s.charAt(i)-'0'].offer(i);
        }
        //从t开始找，s[ti]的左侧必须都大于s[ti]（因为需要把s[ti]移到左侧,也可以说小于s[ti]的值都在右侧），然后从队列删除
        for (int i = 0; i < n; i++) {
            int pos = t.charAt(i)-'0';
            if (queueArr[pos].isEmpty()){
                return false;
            }
            for (int j = 0; j < pos; j++) {
                if (!queueArr[j].isEmpty() && queueArr[j].peek() < queueArr[pos].peek()){
                    return false;
                }
            }
            queueArr[pos].poll();
        }
        return true;
    }
}
