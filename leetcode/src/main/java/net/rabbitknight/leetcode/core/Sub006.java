package net.rabbitknight.leetcode.core;

public class Sub006 {
    public String convert(String s, int numRows) {
        if (null == s || s.length() == 0) {
            return "";
        }
        if (1 == numRows) {
            return s;
        }

        int row = numRows;
        String[] strs = new String[row];
        int jump = (row - 1) * 2;   // 间隔数
        for (int i = 0; i < row; i++) {
            // 第一行和最后一行
            if (i == 0 || i == row - 1) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; i + jump * j < s.length(); j++) {
                    sb.append(s.charAt(i + jump * j));
//                    System.out.println("line :" + i + ", add +" + s.charAt(i + jump * j));
                }
                strs[i] = sb.toString();
            } else {
                // 其他行
                StringBuilder sb = new StringBuilder();
                for (int j = 0; i + jump * j < s.length() || jump * j + jump - i < s.length(); j++) {
                    if (j * jump + i < s.length()) {
                        sb.append(s.charAt(j * jump + i));
//                        System.out.println("line :" + i + ", add1 +" + s.charAt(j * jump + i));
                    }
                    if (jump * j + jump - i < s.length()) {
                        sb.append(s.charAt(jump * j + jump - i));
//                        System.out.println("line :" + i + ", add2 +" + s.charAt(jump * j + jump - i)) ;
                    }
                }
                strs[i] = sb.toString();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String string : strs) {
            sb.append(string);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Sub006 sub = new Sub006();
        String input = "ABCDE";
        String rst = sub.convert(input, 4);
        System.out.println(rst);
    }
}
