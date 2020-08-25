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
        int[] nums = new int[] {1, 3, 1, 2, 0, 5};
        int k = 3;

//        int[] nums = new int[] {1, -1};
//        int k = 1;
//        int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;

        int[] result = maxSlidingWindow(nums, k);
        System.out.println(GsonUtil.array2Json(Arrays.asList(result)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int size;
        if (nums == null || (size = nums.length) == 0) return new int[0];

        Deque<Integer> deque = new LinkedList<Integer>();
        int[] result = new int[size - k + 1];

        for (int i = 0; i < size; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 去掉超过窗口大小的数据
            if (deque.peek() <= i - k) {
                deque.poll();
            }

            if (i >= k - 1) {
                result[i + 1 - k] = nums[deque.peek()];
            }
        }
        return result;
    }
}
