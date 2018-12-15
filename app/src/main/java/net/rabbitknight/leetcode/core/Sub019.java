package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.PrintHelper;
import net.rabbitknight.leetcode.structure.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class Sub019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode second = first;
        head = first;
        int i = 0;
        while (i++ < n) {
            second = second.next;
        }
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
        return head.next;
    }

    public static void main(String[] args) {
        Sub019 sub = new Sub019();
        ListNode head = new ListNode(1);
        ListNode current = head;

        int count = 1;
        while (++count < 6) {
            current.next = new ListNode(count);
            current = current.next;
        }

//        print(head);
        head = sub.removeNthFromEnd(head, 2);
        PrintHelper.print(head);
    }



}
