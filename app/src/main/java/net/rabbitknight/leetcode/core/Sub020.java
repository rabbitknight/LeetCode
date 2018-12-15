package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Sub020 {
    public boolean isValid(String s) {
        if (null == s) {
            return false;
        }
        if ("".equals(s)){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty()||'(' != stack.pop()) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty()||'[' != stack.pop()) {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty()||'{' != stack.pop()) {
                        return false;
                    }
                    break;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Sub020 sub = new Sub020();
        Printer.println(sub.isValid("["));

    }
}
