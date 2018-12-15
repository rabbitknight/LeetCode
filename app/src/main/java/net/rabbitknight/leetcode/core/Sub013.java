package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

import java.util.HashMap;
import java.util.Map;

public class Sub013 {
    public int romanToInt(String s) {
        return solveEngine2(s);
    }

    private int solveEngine1(String s) {
        // M,CM,D,CD,C,XC,L,XL,X,IX,V,IV,I
        int total[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] tomans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Map<String, Integer> map = new HashMap<>();

        int rst = 0;
        for (int i = 0; i < tomans.length; i++) {
            map.put(tomans[i], i);
        }
        for (int i = 0; i < s.length(); ) {
//            PrintHelper.println(i);
            int offset = 1;
            String sub = s.substring(i, i + offset);
            while (map.containsKey(sub)) {
//                PrintHelper.println(sub, offset);
                offset++;
                if (i + offset > s.length()) {
                    break;
                }
                sub = s.substring(i, i + offset);
            }
            sub = s.substring(i, i + offset - 1);
            if (map.containsKey(sub)) {
                rst += total[map.get(sub)];
                i += (sub.length());
            } else {
                return 0;
            }
        }
        return rst;
    }

    private int solveEngine2(String s) {
        // M,CM,D,CD,C,XC,L,XL,X,IX,V,IV,I
//        int total[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//        String[] tomans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int sum = 0;
        int i;
        for (i = 0; i < s.length() - 1; ) {
            switch (s.charAt(i)) {
                case 'M':
                    sum += 1000;
                    i++;
                    break;
                case 'C':

                    if ('M' == s.charAt(i + 1)) {
                        sum += 900;
                        i += 2;
                    } else if ('D' == s.charAt(i + 1)) {
                        sum += 400;
                        i += 2;
                    } else {
                        sum += 100;
                        i++;
                    }
                    break;
                case 'D':
                    sum += 500;
                    i++;
                    break;
                case 'X':
                    if ('C' == s.charAt(i + 1)) {
                        sum += 90;
                        i += 2;
                    } else if ('L' == s.charAt(i + 1)) {
                        sum += 40;
                        i += 2;
                    } else {
                        sum += 10;
                        i++;
                    }
                    break;
                case 'L':
                    sum += 50;
                    i++;
                    break;
                case 'I':
                    if ('X' == s.charAt(i + 1)) {
                        sum += 9;
                        i += 2;
                    } else if ('V' == s.charAt(i + 1)) {
                        sum += 4;
                        i += 2;
                    } else {
                        sum += 1;
                        i++;
                    }
                    break;
                case 'V':
                    sum += 5;
                    i++;
                    break;

            }
        }
        if (i != s.length()) {
            int x = 0;
            switch (s.charAt(i)) {
                case 'M':
                    x = 1000;
                    break;
                case 'D':
                    x = 500;
                    break;
                case 'C':
                    x = 100;
                    break;
                case 'L':
                    x = 50;
                    break;
                case 'X':
                    x = 10;
                    break;
                case 'V':
                    x = 5;
                    break;
                case 'I':
                    x = 1;
                    break;
            }
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        Sub013 sub = new Sub013();
        Printer.println(sub.romanToInt("III"));
    }
}
