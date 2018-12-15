package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;
import net.rabbitknight.leetcode.structure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Sub022 {
    public List<String> generateParenthesis(int n) {
        List<String> rst = new LinkedList<>();
        char[] temp = new char[n * 2];
        recursion(rst, temp, 0, 0, n);
        return rst;
    }

    private void recursion(List<String> rst, char[] tmp, int left, int right, int n) {
        if (left + right == n * 2) {
            rst.add(new String(tmp));
            return;
        }
        if (left < n) {
            tmp[left + right] = '(';
            recursion(rst, tmp, left + 1, right, n);
        }
        if (right < left) {
            tmp[left + right] = ')';
            recursion(rst,tmp,left,right+1,n);
        }
    }

    public static void main(String[] args) {
        Sub022 sub = new Sub022();
        Printer.println(sub.generateParenthesis(3));
    }
}
