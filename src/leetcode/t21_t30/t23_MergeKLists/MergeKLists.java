package leetcode.t21_t30.t23_MergeKLists;

import leetcode.preparation.linkednode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

import static leetcode.preparation.linkednode.PrepareListNode.generate;
import static leetcode.preparation.linkednode.PrepareListNode.print;

/**
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {

    public static void main(String[] args) {
        print(mergeKLists1(new ListNode[]{generate(1, 4, 5), generate(1, 3, 4), generate(2, 6)}));
        print(mergeKLists2(new ListNode[]{generate(1, 4, 5), generate(1, 3, 4), generate(2, 6)}));
    }

    /**
     * 分而治之
     *
     * 链表两两合并
     */
    private static ListNode mergeKLists1(ListNode[] lists) {
        int length;
        if (lists == null || (length = lists.length) == 0) {
            return null;
        }

        return merge(lists, 0, length - 1);
    }

    private static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int middle = left + ((right - left) >> 1);

        ListNode l1 = merge(lists, left, middle);
        ListNode l2 = merge(lists, middle + 1, right);

        return mergeTwoLists(l1, l2);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 优先级队列
     *
     * 时间复杂度：O(n∗log(k))，n 是所有链表中元素的总和，k 是链表个数。
     */
    private static ListNode mergeKLists2(ListNode[] lists) {
        int length;
        if (lists == null || (length = lists.length) == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
            if (temp.next != null) {
                queue.offer(temp.next);
            }
        }

        return head.next;
    }
}
