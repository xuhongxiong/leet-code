package com.xhx.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 * 输入: s = "leetcode"
 * 输出: 0
 *
 * 1 <= s.length <= 105
 * s 只包含小写字母
 */
public class Test8 {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)){
                Integer integer = map.get(aChar);
                map.put(aChar,integer + 1);
            } else {
                map.put(aChar,1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
