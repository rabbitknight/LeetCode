package net.rabbitknight.leetcode;

import net.rabbitknight.leetcode.structure.ListNode;

public class PrintHelper {

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
            PrintHelper.println(current.val);
            current = current.next;
        }
    }

}
