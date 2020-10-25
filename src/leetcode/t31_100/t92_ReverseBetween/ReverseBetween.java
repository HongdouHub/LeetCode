package leetcode.t31_100.t92_ReverseBetween;

import leetcode.preparation.linkednode.ListNode;
import leetcode.preparation.linkednode.PrepareListNode;

import static leetcode.preparation.linkednode.PrepareListNode.generate;
import static leetcode.preparation.linkednode.PrepareListNode.print;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 *      1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *      输入: 1->2->3->4->5->NULL, m = 2, n = 4
 *      输出: 1->4->3->2->5->NULL
 */
public class ReverseBetween {

    public static void main(String[] args) {
        print(reverseBetween(generate(1, 2, 3, 4, 5), 2, 4));
        print(reverseBetween(generate(3, 5), 1, 2));
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        return PrepareListNode.reverseList(head, m, n);
    }

}
