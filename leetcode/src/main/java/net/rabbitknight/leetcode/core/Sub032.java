package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class Sub032 {


/*    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int stack = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int last = 0;   // 最后一次pop完为空的地方
        flag:
        while (index < chars.length) {
            // 如果是以) 开始 直接下一个
            if (chars[index] == ')') {
                index++;
                continue flag;
            }
            stack = 0;

            for (int i = index; i < chars.length; i++) {
                switch (chars[i]) {
                    case '(': {
                        stack++;
                        if (i == chars.length - 1) {
                            index++;
                            continue flag;
                        }
                    }
                    break;
                    case ')': {
                        // 栈是空的 还pop 个p 直接修改参数 到上一次最后 或者是直接个地方
                        if (stack == 0){
                            index = Math.max(last + 1, index + 1);
                            continue flag;
                        }
                        // 栈不空 pop 栈
                        stack--;
                        // 如果pop完 栈空了 记录最后的位置
                        if (stack == 0) {
                            last = i;
                            map.put(index, last);
                        }
                        if (i == chars.length - 1) {
                            index = Math.max(last + 1, index + 1);
                            continue flag;
                        }
                    }
                    break;
                }
            }
        }
//        Printer.println(map);
        return calculate(map);
    }


    private int calculate(Map<Integer, Integer> map) {
        int max = 0;
        for (Integer index : map.keySet()) {
            Integer v = map.get(index);
            while (map.get(v + 1) != null) {
                v = map.get(v + 1);
            }

            int tmp = v - index + 1;
            max = Math.max(tmp, max);
        }
        return max;
    }*/

    // region new
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('), calc(chars, chars.length - 1, -1, -1, ')'));
    }

    private static int calc(char[] chars, int i, int flag, int end, char cTem) {
        int max = 0, sum = 0, currLen = 0, validLen = 0;
        for (; i != end; i += flag) {
            sum += (chars[i] == cTem ? 1 : -1);
            currLen++;
            if (sum < 0) {
                max = max > validLen ? max : validLen;
                sum = 0;
                currLen = 0;
                validLen = 0;
            } else if (sum == 0) {
                validLen = currLen;
            }
        }
        return max > validLen ? max : validLen;
    }

    public int longestValidParentheses(String s,int oo) {
        int left = 0, right = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left * 2);
            }
            if (right > left) {
                left = right = 0;
            }

        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left * 2);
            }
            if (right < left) {
                left = right = 0;
            }

        }
        return result;
    }

    // endregion new


    public static void main(String[] args) {
        Printer.start();
        Sub032 sub032 = new Sub032();
        int rst = 0;
        rst = sub032.longestValidParentheses(")()())()((",0);
        Printer.println(rst);
/*        rst = sub032.longestValidParentheses("((");
        Printer.println(rst);
        rst = sub032.longestValidParentheses(")()())((");
        Printer.println(rst);
        rst = sub032.longestValidParentheses("(()");
        Printer.println(rst);*/
    }

}
