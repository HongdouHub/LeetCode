package leetcode.t11_t20.t19_RemoveNthFromEnd;

import leetcode.preparation.linkednode.ListNode;
import leetcode.preparation.linkednode.PrepareListNode;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        PrepareListNode.print(removeNthFromEnd(
                PrepareListNode.generate(new Integer[]{1, 2}), 1));

        PrepareListNode.print(removeNthFromEnd(
                PrepareListNode.generate(new Integer[]{1, 2, 3, 4, 5}), 2));
    }

    /**
     * 快慢指针
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lowNode = head;
        ListNode fastNode = head;

        while (n > 0) {
            if (fastNode != null) {
                fastNode = fastNode.next;
            }
            n--;
        }

        ListNode tmp = null;
        for (;lowNode != null;) {

            if (fastNode == null) {
                if (tmp == null) {
                    head = lowNode.next;
                } else {
                    tmp.next = lowNode.next;
                }
                break;
            } else {
                tmp = lowNode;
                fastNode = fastNode.next;
                lowNode = lowNode.next;
            }
        }


//        while (fastNode != null) {
//
//            if (fastNode.next == null) {
//                lowNode.next = lowNode.next.next;
//                break;
//            } else {
//                fastNode = fastNode.next;
//                lowNode = lowNode.next;
//            }
//
//        }
        return head;
    }

}
