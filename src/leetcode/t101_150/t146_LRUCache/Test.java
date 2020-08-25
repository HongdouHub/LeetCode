package leetcode.t101_150.t146_LRUCache;

/**
 * 146. LRU缓存机制
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key)
 *      - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），
 *      - 否则返回 -1。
 * 写入数据 put(key, value)
 *      - 如果关键字已经存在，则变更其数据值；
 *      - 如果关键字不存在，则插入该组「关键字/值」。
 *      当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class Test {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test2() {
        LRUCache<Integer> cache = new LRUCache<Integer>(1);

        cache.put(2, 1);
        print(cache.get(2));

    }

    private static void test1() {
        LRUCache<Integer> cache = new LRUCache<Integer>(2);

        cache.put(1, 1);
        cache.put(2, 2);
        print(cache.get(1)); // 返回  1

        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        print(cache.get(2)); // 返回 -1 (未找到)

        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        print(cache.get(1)); // 返回 -1 (未找到)
        print(cache.get(3)); // 返回  3
        print(cache.get(4)); // 返回  4
    }

    private static void print(Integer integer) {
        System.out.println(integer == null ? -1 : integer);
    }

}
