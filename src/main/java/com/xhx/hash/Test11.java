package com.xhx.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class Test11 {
    @Test
    public void test(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sort = sort(str);
            if (map.containsKey(sort)){
                map.get(sort).add(str);
            } else {
                map.put(sort, new ArrayList<>(Collections.singletonList(str)));
            }
        }
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        List<List<String>> res = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> next = iterator.next();
            res.add(next.getValue());
        }
        return res;
    }

    private String sort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
