package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

public class Sub012 {

    /**
     * int 转 罗马数字
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        // M,CM,D,CD,C,XC,L,XL,X,IX,V,IV,I
        int total[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] tomans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total.length; i++) {
            int temp = num / total[i];
            for (int j = 0; j < temp; j++) {
                sb.append(tomans[i]);
//                PrintHelper.println(tomans[i]);
            }
            num = num % total[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Sub012 sub = new Sub012();
        Printer.println(sub.intToRoman(1994));
    }
}
