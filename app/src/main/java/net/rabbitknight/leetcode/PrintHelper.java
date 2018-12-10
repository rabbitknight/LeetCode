package net.rabbitknight.leetcode;

public class PrintHelper {

    public static void println(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- ")
                .append(msg);
        System.out.println(sb.toString());
    }

    public static void println(Object... msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- ");
        for (Object txt : msg) {
            sb.append(txt).append(" ");
        }
        System.out.println(sb.toString());
    }

}
