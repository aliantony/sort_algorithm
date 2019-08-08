package com.learn.sort;
import	java.util.HashMap;

import java.util.Map;

/**
 * @program sort_algorithm
 * @description 滑动窗口求字符串最长不重复子串
 * @author wangqian
 * created on 2019-08-08
 * @version  1.0.0
 */
public class StringMaxSubStr {
    public static void main(String[] args) {
        String str = "pwwkewkjldfgwdsfjxidsmmmmmmmmaaaa";
        int maxlength = 0;
        int len = str.length();
        //记录下一个不重复字符的位置
        int start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (; end < len; end++) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            map.put(c, end + 1);
            maxlength = Math.max(maxlength, end - start + 1);
        }
        System.out.println("最大长度:" + maxlength);
        System.out.println(str.substring(start, end));
    }
}
