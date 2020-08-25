package leetcode.t1_t10.t2_AddTwoNumbers;

import leetcode.preparation.linkednode.ListNode;
import leetcode.preparation.linkednode.PrepareListNode;

/**
 * 2. 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = PrepareListNode.generate(new Integer[] {1});
        ListNode l2 = PrepareListNode.generate(new Integer[] {9, 9});

        ListNode listNode = addTwoNumbers(l1, l2);
        PrepareListNode.print(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode tmp3 = null;

        int carryBit = 0;
        int currentBit = 0;

        while (l1 != null || l2 != null || carryBit != 0) {
            currentBit = 0;
            if (l1 != null) {
                currentBit = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                currentBit += l2.val;
                l2 = l2.next;
            }

            if (tmp3 == null) {
                tmp3 = new ListNode((currentBit + carryBit) % 10);
                result = tmp3;
            } else {
                tmp3.next = new ListNode((currentBit + carryBit) % 10);
                tmp3 = tmp3.next;
            }

            carryBit = (currentBit + carryBit ) / 10;
        }

        return result;
    }

}
