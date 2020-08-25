package leetcode.t703_KthLargest;


import java.util.PriorityQueue;

/**
 * 数据流中的第K大元素
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
