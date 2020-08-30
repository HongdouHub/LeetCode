package leetcode.t201_250.t239_MaxSlidingWindow;

import utils.GsonUtil;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
//        int[] nums = new int[] {1, -1};
//        int k = 1;
//        int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;

        print(maxSlidingWindow1(new int[] {1, 3, 1, 2, 0, 5}, 3));
        print(maxSlidingWindow2(new int[] {1, 3, 1, 2, 0, 5}, 3));
    }

    /**
     * 暴力求解
     *
     * 时间复杂度：O(Nk)
     * 空间复杂度：O(N−k+1)
     */
    private static int[] maxSlidingWindow1(int[] nums, int k) {
        int n;
        if (nums == null || k * (n = nums.length) == 0) {
            return new int[0];
        }

        int length = n - k + 1;
        int[] output = new int[length];
        int max;
        for (int i = 0; i < length; i++) {
            max = Integer.MIN_VALUE;

            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    /**
     * 双向队列
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    private static int[] maxSlidingWindow2(int[] nums, int k) {
        int n;
        if (nums == null || k * (n = nums.length) == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<Integer>();
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 去掉超过窗口大小的数据
            if (deque.peek() <= i - k) {
                deque.poll();
            }

            if (i >= k - 1) { // >=2
                result[i + 1 - k] = nums[deque.peek()];
            }
        }
        return result;
    }

    private static void print(int[] result) {
        System.out.println(GsonUtil.array2Json(Arrays.asList(result)));
    }
}
