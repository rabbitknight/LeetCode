package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.PrintHelper;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Sub014 {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return "";
        }
        if (1 == strs.length) {
            return strs[0] == null ? "" : strs[0];
        }
        String cmp = strs[0];
        int index = 0;
        int length = cmp.length();
        hhh:
        while (index < length) {
            char cmpc = cmp.charAt(index);
            for (String str : strs) {
                if (index >= str.length() || cmpc != str.charAt(index)) {
                    break hhh;
                }
            }
            index++;
        }
        return cmp.substring(0, index);
    }

    public static void main(String[] args) {
        Sub014 sub = new Sub014();
        String[] input = new String[]{"asa", "as"};
        PrintHelper.println(sub.longestCommonPrefix(input));
    }
}
