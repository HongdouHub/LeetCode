package leetcode.t31_100.t83_DeleteDuplicates;

import leetcode.preparation.linkednode.ListNode;

import java.util.HashSet;
import java.util.Set;

import static leetcode.preparation.linkednode.PrepareListNode.generate;
import static leetcode.preparation.linkednode.PrepareListNode.print;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *      输入: 1->1->2
 *      输出: 1->2
 *
 * 示例 2:
 *      输入: 1->1->2->3->3
 *      输出: 1->2->3
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        print(deleteDuplicates(generate(1, 1, 2)));
        print(deleteDuplicates(generate(1, 1, 2, 3, 3)));
        print(deleteDuplicates(generate(1, 1, 1)));
    }

    /**
     * 哈希表法
     *
     * 时间复杂度： O(n)
     * 空间复杂度： O(n)
     */
    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = head;
        ListNode prev = head;
        Set<Integer> set = new HashSet<>();

        while (head != null) {

            if (!set.contains(head.val)) {
                set.add(head.val);
                prev = head;
                head = head.next;
            } else {

                while (head != null) {
                    if (!set.contains(head.val)) {
                        break;
                    }
                    head = head.next;
                }

                prev.next = head;
                prev = head;
            }
        }
        return root;
    }

}
