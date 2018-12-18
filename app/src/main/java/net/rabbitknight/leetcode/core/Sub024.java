package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;
import net.rabbitknight.leetcode.structure.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Sub024 {
    public ListNode swapPairs(ListNode head) {
        ListNode current = new ListNode(0);
        ListNode first = current;
        current.next = head;
        int index = 0;
        while (current.next != null) {
            if (0 == index % 2) {
                ListNode left = current.next;
                ListNode right = current.next.next;
                if (right == null) {
                    break;
                }
                ListNode end = current.next.next.next;
                current.next = right;
                right.next = left;
                left.next = end;
            }
            current = current.next;
            index++;
        }
        return first.next;
    }

    public static void main(String[] args) {
        Sub024 sub = new Sub024();
        ListNode list = new ListNode(0);
        ListNode head = list;
/*        for (int i = 1; i < 3; i++) {
            list.next = new ListNode(i);
            list = list.next;
        }*/
        Printer.print(head);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Printer.print(sub.swapPairs(head));

    }
}
