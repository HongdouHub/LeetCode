package leetcode.t201_250.t206_ReverseLinkedList.single;

/**
 * 206. 反转链表 - 单链表
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
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    public static void main(String[] args) {
        Node<Integer> node = generateLinkedList();
        print(node);

        node = reverse(node);
        print(node);
    }

    /**
     * 反转链表： 单向链表
     */
    private static <T> Node<T> reverse(Node<T> head) {
        Node<T> node = head;
        Node<T> prev = null;
        Node<T> next = null;

        while (node != null) {
            next = node.next;

            node.next = prev;
            prev = node;

            node = next;
        }
        return prev;
    }

    private static void print(Node<?> head) {
        Node<?> node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

}
