package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 *
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 *
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 *
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 *
 * 示例 1：
 *
 * 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * 输出：1
 * 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 *
 * 提示：
 *
 * 1 <= items.length <= 104
 * 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
 * ruleKey 等于 "type"、"color" 或 "name"
 * 所有字符串仅由小写字母组成
 */
public class Test16 {

    @Test
    public void test(){
        String[][] itemArr = {{"phone","blue","pixel"},{"computer","silver","lenovo"},{"phone","gold","iphone"}};
        List<List<String>> items = new ArrayList<>();
        for (String[] strings : itemArr) {
            items.add(Arrays.asList(strings));
        }
        System.out.println(countMatches(items,"color","silver"));
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        for (List<String> item : items) {
            if ("type".equals(ruleKey) && item.get(0).equals(ruleValue)){
                res++;
            } else if ("color".equals(ruleKey) && item.get(1).equals(ruleValue)){
                res++;
            } else if ("name".equals(ruleKey) && item.get(2).equals(ruleValue)){
                res++;
            }
        }
        return res;
    }
}
