package net.rabbitknight.leetcode.core;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 */

public class Sub029 {
    /*
     * copy from https://blog.csdn.net/qq_18870127/article/details/80654042
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1 || divisor == 1) {
                return divisor == -1 ? ~dividend : dividend;
            }
        }

        int flag = 1;
        long div = dividend, dor = divisor;
        if (div < 0) {
            flag *= -1;
            div *= -1;
        }
        if (dor < 0) {
            flag *= -1;
            dor *= -1;
        }
        int re = 0;
        while (div >= dor) {
            long aa = 1, temp = dor;
            while (temp < div >> 1) {
                temp <<= 1;
                aa <<= 1;
            }
            div -= temp;
            re += aa;
        }
        return re * flag;
    }


    public static void main(String[] args) {
    }
}
