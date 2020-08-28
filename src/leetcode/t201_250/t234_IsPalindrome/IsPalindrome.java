package leetcode.t201_250.t234_IsPalindrome;

import leetcode.preparation.linkednode.ListNode;

import java.util.ArrayList;
import java.util.List;

import static leetcode.preparation.linkednode.PrepareListNode.generate;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome1(generate(new Integer[] {1, 2, 2, 1})));
        System.out.println(isPalindrome2(generate(new Integer[] {1, 2, 2, 1})));
    }

    /**
     * 将值复制到数组中后用双指针法
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {

            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 反转后半部分链表
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;

        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 可不反转回来
        firstHalfEnd.next = reverseList(secondHalfStart);

        return result;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode temp;

        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
