package leetcode.t21_t30.t23_MergeKLists;

import leetcode.preparation.linkednode.ListNode;
import leetcode.preparation.linkednode.PrepareListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

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
        ListNode node1 = PrepareListNode.generate(new Integer[]{1, 4, 5});
        ListNode node2 = PrepareListNode.generate(new Integer[]{1, 3, 4});
        ListNode node3 = PrepareListNode.generate(new Integer[]{2, 6});
        PrepareListNode.print(mergeKLists1(new ListNode[]{node1, node2, node3}));
        PrepareListNode.print(mergeKLists2(new ListNode[]{node1, node2, node3}));
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

        int middle = (left + right) >> 1;

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
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
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
