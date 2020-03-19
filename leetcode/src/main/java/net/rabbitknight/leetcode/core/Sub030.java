package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 */
public class Sub030 {

    public static void main(String[] args) {
        Sub030 sub = new Sub030();
        String s = "aaa";
        String[] words = new String[]{"a", "a"};

        Printer.println(sub.findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> lists = new ArrayList<>();    // 索引
        if (words.length == 0) {
            return lists;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer count = map.get(word);
            if (null == count) {
                count = 1;
            } else {
                count++;
            }
            map.put(word, count);
        }

        HashMap<String, Integer> clone = (HashMap<String, Integer>) map.clone();

        int wordLength = words[0].length();
        int totalLength = words.length * wordLength;

        flag1:
        for (int i = 0; i + totalLength < s.length() + 1; i++) {
            for (int j = 0; j < words.length; j++) {
                String key = s.substring(i + j * wordLength, j * wordLength + wordLength + i);
                // 如果没有匹配到 下一个字符
                Integer count = clone.get(key);
//                Printer.println("key = [" + key + "], count = [" + count + "]");
                if (count == null || count == 0) {
                    clone = (HashMap<String, Integer>) map.clone();
                    continue flag1;
                }
                count--;
                clone.put(key, count);
            }
            clone = (HashMap<String, Integer>) map.clone();
            lists.add(i);
        }

        return lists;
    }
}

