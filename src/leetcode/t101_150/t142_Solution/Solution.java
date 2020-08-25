package leetcode.t101_150.t142_Solution;

import leetcode.preparation.linkednode.ListNode;

import java.util.HashSet;
import java.util.Set;

import static leetcode.preparation.linkednode.PrepareListNode.generateCycle;

/**
 * 142. 环形链表 II
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 */
@SuppressWarnings("all")
public class Solution {

    public static void main(String[] args) {
        System.out.println(detectCycle1(generateCycle(new Integer[]{3, 2, 0, -4, 2})));
        System.out.println(detectCycle2(generateCycle(new Integer[]{3, 2, 0, -4, 2})));
    }

    /**
     * 哈希表
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();

        while (head.next != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * Floyd 算法
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode pNode1 = getCommonNode(head);
        if (pNode1 == null) {
            return null;
        }

        ListNode pNode2 = head;

        while (pNode1 != pNode2 && pNode1 != null && pNode2 != null) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }

        return pNode1;
    }

    private static ListNode getCommonNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

}
