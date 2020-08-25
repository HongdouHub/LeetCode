package leetcode.t21_t30.t21_MergeTwoLists;

import leetcode.preparation.linkednode.ListNode;
import leetcode.preparation.linkednode.PrepareListNode;

/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = PrepareListNode.generate(new Integer[]{1, 2, 4});
        ListNode l2 = PrepareListNode.generate(new Integer[]{1, 3, 4});

        PrepareListNode.print(mergeTwoLists1(l1, l2));
        PrepareListNode.print(mergeTwoLists2(l1, l2));
    }

    private static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode result = new ListNode(0);
        head.next = result;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }

        if (l1 == null) {
            while (l2 != null) {
                result.next = new ListNode(l2.val);
                result = result.next;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                result.next = new ListNode(l1.val);
                result = result.next;
                l1 = l1.next;
            }
        }
        return head.next.next;
    }

    private static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
