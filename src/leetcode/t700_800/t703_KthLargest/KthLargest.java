package leetcode.t700_800.t703_KthLargest;


import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 *
 * 设计一个找到数据流中第 k 大元素的类（class）。
 * 注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *     KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 *     int add(int val) 返回当前数据流中第 k 大的元素。
 */
public class KthLargest {

    private final int mK;
    private final PriorityQueue<Integer> mMinHeap; // 优先队列

    public KthLargest(int k, int[] nums) {
        this.mK = k;
        this.mMinHeap = new PriorityQueue<>(k);

        int size = nums.length;
        for (int i = 0; i < size; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        Integer peek = mMinHeap.peek();

        if (mMinHeap.size() < mK) {
            mMinHeap.offer(val);
        } else if (peek != null && peek < val) {
            mMinHeap.poll();
            mMinHeap.offer(val);
        }
        return (peek = mMinHeap.peek()) != null ? peek : 0;
    }
}
