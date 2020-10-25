package leetcode.t101_150.t146_LRUCache;

public class Node<T> {

    int key;
    Node<T> prev;
    Node<T> next;
    T item;

    public Node() {
    }

    public Node(int key, Node<T> prev, Node<T> next, T item) {
        this.key = key;
        this.prev = prev;
        this.next = next;
        this.item = item;
    }
}
