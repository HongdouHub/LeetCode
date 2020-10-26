package leetcode.t700_800.t703_KthLargest;

/**
 * 703. 数据流中的第 K 大元素
 *
 * 设计一个找到数据流中第 k 大元素的类（class）。
 * 注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *     KthLargest(int k, int[] nums)    使用整数 k 和整数流 nums 初始化对象。
 *     int add(int val)                 返回当前数据流中第 k 大的元素。
 *
 */
public class Solution {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});

        System.out.println(kthLargest.add(3));  // returns 4
        System.out.println(kthLargest.add(5));  // returns 5
        System.out.println(kthLargest.add(10)); // returns 5
        System.out.println(kthLargest.add(9));  // returns 8
        System.out.println(kthLargest.add(4));  // returns 8
    }
}
