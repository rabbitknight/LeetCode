package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.PrintHelper;

public class Sub009 {

    public static boolean isPalindrome(int x) {
        if (0 == x) {
            return true;
        }
        if (0 > x) {
            return false;
        }
        int total[] = new int[10];
        int p = 0;
        while (x != 0) {
            total[p++] = x % 10;
            x /= 10;
        }
        int i = 0;
        int j = p - 1;


        while (i < (p / 2.0f)) {
            if (total[i++] != total[j--]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        PrintHelper.println(isPalindrome(110));
        PrintHelper.println(isPalindrome(1));
        PrintHelper.println(isPalindrome(01));
        PrintHelper.println(isPalindrome(1234321));
    }
}
