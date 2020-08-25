package leetcode.t101_150.t146_LRUCache;

public class Node1<T> {

    int key;
    Node<T> prev;
    Node<T> next;
    T item;

    public Node1() {
    }

    public Node1(int key, Node<T> prev, Node<T> next, T item) {
        this.key = key;
        this.prev = prev;
        this.next = next;
        this.item = item;
    }
}
