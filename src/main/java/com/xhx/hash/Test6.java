package com.xhx.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 */
public class Test6 {
    @Test
    public void test(){
        System.out.println(isIsomorphic("badc","baba"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        for (int i = 0; i < charsS.length; i++) {
            if (map.containsKey(charsS[i])){
                if (map.get(charsS[i]).equals(charsT[i])){
                    continue;
                } else {
                    return false;
                }
            }
            if (map.containsValue(charsT[i])){
                return false;
            }
            map.put(charsS[i],charsT[i]);
        }
        return true;
    }
}
