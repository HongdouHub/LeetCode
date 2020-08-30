package leetcode.preparation.linkednode;

import java.util.HashSet;
import java.util.Set;

public class PrepareListNode {

    public static ListNode generate(Integer[] array) {
        if (array == null) return null;

        ListNode result = null;
        ListNode tmp = null;
        int size = array.length;

        for (int i = 0; i < size; i++) {
            if (result == null) {
                result = new ListNode(array[i]);
                tmp = result;
            } else {
                tmp.next = new ListNode(array[i]);
                tmp = tmp.next;
            }
        }
        return result;
    }

    public static ListNode generateCycle(Integer[] array) {
        if (array == null) return null;

        Set<ListNode> set = new HashSet<>();
        ListNode result = null;
        ListNode tmp = null;
        int size = array.length;

        outer:for (int i = 0; i < size; i++) {
            ListNode node = new ListNode(array[i]);

            if (result == null) {
                result = node;
                tmp = result;
            } else {

                if (set.contains(node)) {
                    for (ListNode raw : set) {
                        if (node.equals(raw)) {
                            tmp.next = raw;
                            break outer;
                        }
                    }
                }

                set.add(node);
                tmp.next = node;
                tmp = tmp.next;
            }
        }
        return result;
    }

    public static void print(ListNode listNode) {
        System.out.println("-----------------");
        if (listNode == null) {
            System.out.print("null");
        } else {
            while (listNode != null) {
                System.out.print(listNode.val + ", ");
                listNode = listNode.next;
            }
        }
        System.out.println();
        System.out.println("-----------------");
    }

    public static ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    public static ListNode reverseList(ListNode head, ListNode tail) {

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != tail) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
