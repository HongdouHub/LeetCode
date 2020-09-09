package leetcode.t101_150.t141_Solution;

import leetcode.preparation.linkednode.ListNode;

import java.util.HashSet;
import java.util.Set;

import static leetcode.preparation.linkednode.PrepareListNode.generateCycle;

/**
 * 141. 环形链表
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 */
@SuppressWarnings("all")
public class Solution {

    public static void main(String[] args) {
        System.out.println(hasCycle1(generateCycle(new Integer[]{3, 2, 0, -4, 2})));
        System.out.println(hasCycle2(generateCycle(new Integer[]{3, 2, 0, -4, 2})));

        System.out.println(hasCycle1(generateCycle(new Integer[]{1, 2})));
        System.out.println(hasCycle2(generateCycle(new Integer[]{1, 2})));
    }

    /**
     * 哈希表
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head.next != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针
     * <p>
     * 时间复杂度：
     *  不存在环：O(n)
     *  存在环：  在最糟糕的情形下，O(N+K)，也就是 O(n)
     * 空间复杂度：O(1)
     */
    private static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
