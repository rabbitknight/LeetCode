package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;
import net.rabbitknight.leetcode.structure.ListNode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Sub023 {

    public ListNode mergeKLists(ListNode[] lists) {
        // TODO: 2018/12/17 合并方法可以优化
        if (lists == null || lists.length < 1) return null;
        int begin = 0;
        int end = lists.length - 1;
        while (end > 0) {
            while (end > begin) {
                lists[begin] = mergeTwoLists(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }

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
        Sub023 sub = new Sub023();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode[] input = new ListNode[]{null};
        Printer.print(sub.mergeKLists(input));
    }
}
