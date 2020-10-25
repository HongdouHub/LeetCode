package leetcode.t101_150.t146_LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> implements Cache<T> {

    private int mSize;
    private Map<Integer, Node<T>> mMap;
    private int mCapacity;
    private Node<T> mHeadNode;
    private Node<T> mTailNode;

    public LRUCache(int capacity) {
        this.mCapacity = capacity;
        this.mMap = new HashMap<Integer, Node<T>>();
        this.mSize = 0;
    }

    @Override
    public T get(int key) {
        Node<T> node;
        if ((node = mMap.get(key)) != null) {
            remove(node);
            addFirst(node);
            return node.item;
        }
        return null;
    }

    @Override
    public void put(int key, T t) {
        Node<T> node;
        if ((node = mMap.get(key)) != null) {
            node.item = t;
            remove(node);
            addFirst(node);
        } else {
            node = new Node<>(key, null, null, t);
            mMap.put(key, node);

            if (mSize < mCapacity) {
                addFirst(node);
            } else {
                mMap.remove(mTailNode.key);
                remove(mTailNode);
                addFirst(node);
            }
        }
    }

    private void addFirst(Node<T> newNode) {
        final Node<T> node = mHeadNode;
        newNode.prev = null;
        newNode.next = node;

        mHeadNode = newNode;
        if (node == null) {
            mTailNode = newNode;
        } else {
            node.prev = newNode;
        }
        mSize++;
    }

    private void remove(Node<T> removeNode) {
        if (mSize == 0) {
            return;
        }

        if (mHeadNode == removeNode) {

            if (mHeadNode.next != null) {
                mHeadNode.next.prev = null;
                mHeadNode = mHeadNode.next;
            } else {
                mHeadNode = null;
                mTailNode = null;
            }
        } else if (mTailNode == removeNode) {

            if (mTailNode.prev != null) {
                mTailNode.prev.next = null;
                mTailNode = mTailNode.prev;
            } else {
                mTailNode = null;
                mHeadNode = null;
            }
        } else {

            removeNode.prev.next = removeNode.next;
            removeNode.next.prev = removeNode.prev;
        }
        mSize--;
    }
}
