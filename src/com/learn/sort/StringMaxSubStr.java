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
        int start = 0, end = 0;
        //记录下一个不重复字符的位置
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int finalStart = 0, finalEnd = 0;
        for (; end < len; end++) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            map.put(c, end + 1);
            int max = end - start + 1;
            if (max > maxlength) {
                maxlength = max;
                finalStart = start;
                finalEnd = end;
            }
        }
        System.out.println("最大长度:" + maxlength);
        System.out.println(str.substring(finalStart, finalEnd + 1));
    }
}
