package net.rabbitknight.leetcode.core;


import java.util.Arrays;

public class Sub005 {

    /**
     * 最长回文数
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        return solveEngine1(s);
    }

    private String solveEngine1(String s) {
        if (null == s || 0 == s.length()) {
            return "";
        }
        char[] max = new char[]{s.charAt(0)};
        for (int i = 0; i < s.length() - 1; i++) {
            char[] rst = clac1(s.toCharArray(), i, i + 1);
            if (rst.length > max.length) {
                max = rst;
            }
        }
        for (int i = 0; i < s.length() - 2; i++) {
            char[] rst = clac1(s.toCharArray(), i, i + 2);
            if (rst.length > max.length) {
                max = rst;
            }
        }
        return String.valueOf(max);
    }

    /**
     * 输出最大的字符串,没有中心的情况
     *
     * @return
     */
    private char[] clac1(char[] raw, int lp, int rp) {
        boolean incycle = false;
        boolean isdouble = (rp - lp + 1) % 2 == 0;
        while (lp >= 0 && rp < raw.length) {
            if (raw[lp] == raw[rp]) {
                lp--;
                rp++;
                incycle = true;
            } else {
                return Arrays.copyOfRange(raw, incycle ? (lp + 1) : lp + (isdouble ? 0 : 1), rp);
            }
        }

        return Arrays.copyOfRange(raw, lp + 1, rp);
    }

    public static void main(String[] args) {
        Sub005 sub = new Sub005();
        String input = "babad";
        String result = sub.longestPalindrome(input);
        System.out.println(result);

    }
}
