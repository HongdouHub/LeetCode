package leetcode.t21_t30.t24_SwapPairs;

import leetcode.preparation.linkednode.ListNode;
import leetcode.preparation.linkednode.PrepareListNode;

import static leetcode.preparation.linkednode.PrepareListNode.print;

/**
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {

    public static void main(String[] args) {
        print(swapPairs1(PrepareListNode.generate(1, 2, 3, 4)));
        print(swapPairs1(PrepareListNode.generate(1, 2, 3, 4, 5)));
        print(swapPairs2(PrepareListNode.generate(1, 2, 3, 4)));
        print(swapPairs2(PrepareListNode.generate(1, 2, 3, 4, 5)));
    }

    /**
     * 非递归解法
     */
    private static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0);
        result.next = head.next;

        ListNode temp;
        ListNode nextTemp;
        ListNode lastHead = null;
        while (head != null) {

            if (head.next == null) {
                break;
            }

            temp = head.next;
            nextTemp = temp.next;
            temp.next = head;
            head.next = nextTemp;

            if (lastHead != null) {
                lastHead.next = temp;
            }
            lastHead = head;
            head = nextTemp;
        }
        return result.next;
    }

    /**
     * 递归解法
     */
    private static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        head.next = swapPairs1(temp.next);
        temp.next = head;

        return temp;
    }
}
