package com.xhx.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 jewels代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。stones中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 *
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 *
 * 1 <=jewels.length, stones.length <= 50
 * jewels 和 stones 仅由英文字母组成
 * jewels 中的所有字符都是 唯一的
 */
public class Test14 {
    public int numJewelsInStones(String jewels, String stones) {
        char[] chars = jewels.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        int res = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c)){
                res += 1;
            }
        }
        return res;
    }
}
