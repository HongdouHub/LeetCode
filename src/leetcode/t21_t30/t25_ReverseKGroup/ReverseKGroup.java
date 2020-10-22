package leetcode.t21_t30.t25_ReverseKGroup;

import leetcode.preparation.linkednode.ListNode;
import leetcode.preparation.linkednode.PrepareListNode;

import static leetcode.preparation.linkednode.PrepareListNode.reverseList;

/**
 * 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        PrepareListNode.print(reverseKGroup(PrepareListNode.generate(1, 2, 3), 2));
        PrepareListNode.print(reverseKGroup(PrepareListNode.generate(1, 2, 3, 4, 5), 2));
        PrepareListNode.print(reverseKGroup(PrepareListNode.generate(1, 2, 3, 4, 5, 6, 7), 3));
    }

    /**
     * 递归解法
     */
    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            } else {
                tail = tail.next;
            }
        }

        // 反转前 k 个元素
        ListNode newHead = reverseList(head, tail);

        // 下一轮的开始的地方就是tail
        head.next = reverseKGroup(tail, k);

        return newHead;
    }

}
