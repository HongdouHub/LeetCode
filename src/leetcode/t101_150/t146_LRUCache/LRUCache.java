package leetcode.t101_150.t146_LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> implements Cache<T> {

    private Map<Integer, Node> mMap;
    private int capacity;
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mMap = new HashMap<Integer, Node>();
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public T get(int key) {
        Node<T> node;
        if ((node = mMap.get(key)) != null) {
            T t = node.item;
            remove(node);
            addFirst(node);
            return t;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public void put(int key, T t) {
        Node<T> node;
        if ((node = mMap.get(key)) != null) {
            node.item = t;
            remove(node);
            addFirst(node);
        } else {
            node = new Node<T>(key, null, null, t);
            mMap.put(key, node);

            if (size < capacity) {
                addFirst(node);
            } else {
                mMap.remove(tail.key);
                remove(tail);
                addFirst(node);
            }
        }
    }

    private void addFirst(Node<T> newNode) {
        final Node<T> node = head;
        newNode.prev = null;
        newNode.next = node;

        head = newNode;
        if (node == null) {
            tail = newNode;
        } else {
            node.prev = newNode;
        }
        size++;
    }

    private void remove(Node<T> removeNode) {
        if (size == 0) {
            return;
        }

        if (head == removeNode) {

            if (head.next != null) {
                head.next.prev = null;
                head = head.next;
            } else {
                head = null;
            }

        } else if (tail == removeNode) {

            if (tail.prev != null) {
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                tail = null;
            }

        } else {
            removeNode.prev.next = removeNode.next;
            removeNode.next.prev = removeNode.prev;
        }
        size--;
    }
}
