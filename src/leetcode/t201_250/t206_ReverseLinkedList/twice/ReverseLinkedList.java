package leetcode.t201_250.t206_ReverseLinkedList.twice;

/**
 * 反转链表 - 双向链表
 *
 * 示例:
 *      输入: 1->2->3->4->5->NULL
 *      输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    private static Node<Integer> generateLinkedList() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);

        node1.next = node2;
        node1.prev = null;

        node2.next = node3;
        node2.prev = node1;

        node3.next = node4;
        node3.prev = node2;

        node4.next = node5;
        node4.prev = node3;

        node5.next = null;
        node5.prev = node4;
        return node1;
    }

    public static void main(String[] args) {
        Node<Integer> head = generateLinkedList();
        print(head);

        head = reverse(head);
        print(head);
    }

    /**
     * 反转链表： 双向链表
     */
    private static <T> Node<T> reverse(Node<T> head) {
        Node<T> node = head;
        Node<T> prev = null;
        Node<T> next = null;
        Node<T> temp = null;

        while (node != null) {
            temp = node.next;
            next = node.next; // 故意添加 next，保留temp，方便理解

            node.next = prev;
            prev = node;

            node.prev = next;
            node = temp;
        }
        return prev;
    }

    private static void print(Node<?> head) {
        Node<?> node = head;
        Node<?> prev = null;

        System.out.println("\nnext traversal");
        while (node != null) {
            System.out.println(node.value);
            prev = node;
            node = node.next;
        }

        System.out.println("prev traversal");
        while (prev != null) {
            System.out.println(prev.value);
            prev = prev.prev;
        }
        System.out.println();
    }
}
