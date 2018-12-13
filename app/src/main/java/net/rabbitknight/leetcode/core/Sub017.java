package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.PrintHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
// TODO: 2018/12/13 BLOCK
public class Sub017 {
    public List<String> letterCombinations(String digits) {
        final List<String> rst = new ArrayList<>();
        if (digits.length() == 0) return new ArrayList<String>();
        char[][] alphabet = new char[][]{
                {}, {},
                {'a', 'b', 'c'},    // index = 2
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        char[] line = new char[digits.length()];
        return recursion(digits, rst, alphabet, line, 0);
    }

    /**
     * 递归计算
     *
     * @param digits   输入数据
     * @param input    返回结果
     * @param alphabet 电话号码表
     * @param line     每一行
     * @param lineId   递归层级
     * @return
     */
    private List<String> recursion(String digits, List<String> input, char[][] alphabet, char[] line, int lineId) {
        int index = digits.charAt(lineId) - '0';
        for (char temp : alphabet[index]) {
            line[lineId] = temp;
            // 如果递归结束
            if (lineId == line.length - 1) {
                input.add(new String(line));
            }
            // 递归
            else {
                recursion(digits, input, alphabet, line, lineId + 1);
            }
        }
        return input;
    }

    public static void main(String[] args) {
        Sub017 sub = new Sub017();
        PrintHelper.println(sub.letterCombinations("23"));
    }
}
