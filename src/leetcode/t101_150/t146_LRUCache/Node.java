package leetcode.t101_150.t146_LRUCache;

public class Node<T> {

    int key;
    Node<T> next;
    Node<T> prev;
    T item;

    public Node() {
        //
    }

    public Node(int key, Node<T> next, Node<T> prev, T item) {
        this.key = key;
        this.next = next;
        this.prev = prev;
        this.item = item;
    }
}
