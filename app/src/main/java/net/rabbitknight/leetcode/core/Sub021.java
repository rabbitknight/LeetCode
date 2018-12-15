package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.structure.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Sub021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sew = new ListNode(0);
        ListNode head = sew;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                sew.next = l1;
                l1 = l1.next;
            } else {
                sew.next = l2;
                l2 = l2.next;
            }
            sew = sew.next;
        }
        if (l1 != null) {
            sew.next = l1;
        } else if (l2 != null) {
            sew.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        // TODO: 2018/12/15 待优化
    }
}
