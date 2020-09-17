package leetcode.t351_400.t382_Solution;

import leetcode.preparation.linkednode.ListNode;

import java.util.Random;

/**
 * 382. 链表随机节点
 *
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。
 * 保证每个节点被选的概率一样。
 *
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 *
 *
 * 这就是道概率题，以 1/i 的概率选择第i个元素就可以 (i=0....size)
 */
public class Solution {

    private ListNode root;
    private Random random = new Random();

    public Solution(ListNode head) {
        this.root = head;
    }

    public int getRandom() {
        ListNode head = root;

        int val = head.val;
        int count = 0;

        while (head != null) {
            count++;
            if (random.nextInt(count) == 0) {
                val = head.val;
            }
            head = head.next;
        }

        return val;
    }
}
