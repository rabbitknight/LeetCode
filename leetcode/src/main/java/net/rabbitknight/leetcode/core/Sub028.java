package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class Sub028 {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int ret = -1;
        char[] raw = haystack.toCharArray();
        char[] need = needle.toCharArray();

        int index = 0;
        while (index <= raw.length - need.length) {
            int x = 0;
            while (x < need.length && raw[index + x] == need[x]) {
                x++;
            }
            if (x == need.length) {
                return index;
            }
            index++;
        }
        return ret;
    }

    public static void main(String[] args) {
        Sub028 sub = new Sub028();
        Printer.println(sub.strStr("aaaaa", "ba"));
    }
}
