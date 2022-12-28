package com.xhx.exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * 示例：
 *
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * 提示：
 *
 * numbers.length == 2
 * -2147483647 <= numbers[i] <= 2147483647
 */
public class Test19 {
    @Test
    public void test(){
        System.out.println(Arrays.toString(swapNumbers(new int[]{1, 2})));
    }

    public int[] swapNumbers(int[] numbers) {
        /*numbers[0] = numbers[0] - numbers[1];
        numbers[1] = numbers[1] + numbers[0];
        numbers[0] = numbers[0] - numbers[1];*/
        //numbers[0] = numbers[0] + numbers[1] - (numbers[1] = numbers[0]);
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
