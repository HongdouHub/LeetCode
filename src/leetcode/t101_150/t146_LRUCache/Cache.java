package leetcode.t101_150.t146_LRUCache;

public interface Cache<T> {

    T get(int key);

    void put(int key, T t);

}
