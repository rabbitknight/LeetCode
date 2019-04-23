package net.rabbitknight.leetcode;

import net.rabbitknight.leetcode.structure.ListNode;

public class Printer {
    private static long begin = 0L;
    private static long end = 0L;

    public static void println(Object... msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- ");
        for (Object txt : msg) {
            sb.append(txt).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void print(ListNode node) {
        ListNode current = node;
        while (current != null) {
            Printer.println(current.val);
            current = current.next;
        }
    }

    public static void start() {
        begin = System.currentTimeMillis();
    }

    public static void end() {
        end = System.currentTimeMillis();
        println("start = ["+begin+"], end = ["+end+"], cost = ["+(end-begin)+"ms]");
    }
}
