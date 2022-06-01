package com.xhx.hash;

import org.junit.Test;

import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Test15 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        System.out.println(sb.substring(1));
        System.out.println(sb.indexOf("1"));
        System.out.println(sb.indexOf("2"));
        sb.delete(0,1);
        System.out.println(sb);
    }
    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("dd"));
    }

    public int lengthOfLongestSubstring(String s) {
        /*StringBuilder sb = new StringBuilder();
        int res = 0;
        for (char c : s.toCharArray()) {
            int indexOf = sb.indexOf(String.valueOf(c));
            if (indexOf != -1){
                sb.delete(0,indexOf+1);
            }
            sb.append(c);
            if (sb.length() > res){
                res = sb.length();
            }
        }
        return res;*/
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int res = 0;
        for (int start = 0, end = 0;end < chars.length;end ++){
            start = Math.max(start,map.getOrDefault(chars[end],0));
            res = Math.max(end-start+1,res);
            map.put(chars[end],end+1);
        }
        return res;
    }
}
