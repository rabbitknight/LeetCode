package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

import java.util.LinkedHashSet;
import java.util.Set;

public class Sub008 {

    public int myAtoi(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        String table = "0123456789";
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < table.length(); i++) {
            set.add(table.charAt(i));
        }
        int begin = -1;
        int end = -1;
        int sign = 0;   // 0 没有,-1负号 1正号
        for (int i = 0; i < str.length(); i++) {
            // 判断起始位置
            if (-1 == begin && ' ' == str.charAt(i)) {  // 如果一直没有begin并且前缀为空则找!
                continue;
            }
            if (-1 == begin && !set.contains(str.charAt(i))
                    && '+' != str.charAt(i)
                    && '-' != str.charAt(i)) {  // 如果字符都不在里面,因为上面已经做过起始位置判断了,则直接返回
                return 0;
            }
            // +-开头,并且下一位不为数字位
            if (-1 == begin) {
                if (('+' == str.charAt(i) || '-' == str.charAt(i))
                        && ((i < str.length() - 1 && !set.contains(str.charAt(i + 1)))
                        || i == str.length() - 1)) {
                    return 0;
                }
            }
            // 不管符号找到开头
            if (-1 == begin && set.contains(str.charAt(i))) {
                begin = i;
            }
            // 找到结尾
            if (-1 != begin
                    && -1 == end
                    && (i + 1 == str.length() || !set.contains(str.charAt(i + 1)))) {
                end = i;
            }

        }
        // 没找到 开头
        if (-1 == begin) {
            return 0;
        }
        // 确认符号位
        if (begin == 0 || '-' != str.charAt(begin - 1)) {
            sign = 1;
        } else {
            sign = -1;
        }

        int result = 0;
        for (int i = begin; i <= end; i++) {
            int temp = Integer.valueOf(str.substring(i, i + 1));
            if (1 == sign && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp >= 7))) {
                return Integer.MAX_VALUE;
            }
            if (-1 == sign
                    && (result > Math.abs(Integer.MIN_VALUE / 10) || (result == Math.abs(Integer.MIN_VALUE / 10) && temp >= 8))) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + temp;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        Sub008 sub = new Sub008();
        Printer.println("" + sub.myAtoi("-2147483649"));
        Printer.println(Integer.MIN_VALUE);
    }
}
