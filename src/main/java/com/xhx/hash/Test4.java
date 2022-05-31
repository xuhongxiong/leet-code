package com.xhx.hash;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 1 <= n <= 231 - 1
 */
public class Test4 {
    @Test
    public void test(){
        System.out.println(isHappy(19));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true){
            //n = square(n);
            int sum = 0;
            while(n != 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = sum;
            if (n == 1){
                return true;
            }
            if (set.contains(n)){
                return false;
            }
            set.add(n);
        }
    }

    private int square(int n){
        String str = n + "";
        int res = 0;
        for (char c : str.toCharArray()) {
            res += Math.pow(Integer.parseInt(String.valueOf(c)),2);
        }
        return res;
    }
}
