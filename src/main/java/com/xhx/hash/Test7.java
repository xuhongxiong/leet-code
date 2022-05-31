package com.xhx.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 *
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 *
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] 和 list2[i] 由空格' '和英文字母组成。
 * list1 的所有字符串都是 唯一 的。
 * list2 中的所有字符串都是 唯一 的。
 */
public class Test7 {

    @Test
    public void test(){
        String[] list1 = {"k","kfc"};
        String[] list2 = {"k","kfc"};
        System.out.println(Arrays.toString(findRestaurant(list1,list2)));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i],i);
        }
        int min = 0;
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])){
                if (stringList.isEmpty()){
                    stringList.add(list2[i]);
                } else if (min > map1.get(list2[i]) + i){
                    stringList.clear();
                    stringList.add(list2[i]);
                } else if (min == map1.get(list2[i]) + i){
                    stringList.add(list2[i]);
                }
                min = map1.get(list2[i]) + i;
            }
        }
        String[] res = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            res[i] = stringList.get(i);
        }
        return res;
    }
}
