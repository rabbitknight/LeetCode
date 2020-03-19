package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

public class Sub011 {
    // TODO: 2018/12/9 暴力法 待优化
    public int maxArea(int[] height) {
        if (null == height || height.length <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Sub011 sub = new Sub011();
        int[] input = new int[]{1,1};
        Printer.println(sub.maxArea(input));
    }
}
