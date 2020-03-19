package net.rabbitknight.leetcode.core;

public class Sub007 {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && temp == 0x7))
                return 0;
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && temp == -0x8))
                return 0;
            ret = ret * 10 + temp;
        }
        return ret;
    }

    public static void main(String[] args) {
        Sub007 sub = new Sub007();
        int out = sub.reverse(-12345);
        System.out.println(out);
    }
}
