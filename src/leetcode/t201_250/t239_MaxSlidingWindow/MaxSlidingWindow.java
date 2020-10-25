package leetcode.t201_250.t239_MaxSlidingWindow;

import leetcode.preparation.MethodBuilder;
import leetcode.preparation.treenode.PrepareTreeNode;
import leetcode.preparation.treenode.TreeNode;
import leetcode.t201_250.t235_LowestCommonAncestor.BinarySearchTree;
import utils.GsonUtil;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static utils.ConsoleUtils.println;

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
        test("maxSlidingWindow1");
        test("maxSlidingWindow2");
    }

    private static void test(String methodName) {
        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(MaxSlidingWindow.class)
                .setMethodName(methodName)
                .setParameterTypes(int[].class, int.class)
                .build();

        System.out.println(String.format("-------------%s------------", methodName));

        print((int[]) builder.invoke(new int[] {1, -1}, 1));                            // [1,-1]
        print((int[]) builder.invoke(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));         // [3,3,5,5,6,7]
        print((int[]) builder.invoke(new int[] {1, 3, 1, 2, 0, 5}, 3));                 // [3,3,2,5]
        print((int[]) builder.invoke(new int[] {10000, 10001, 10002, 10003, 10004}, 3));// [10002,10003,10004]
        System.out.println("----------------------------------------\n");
    }

    private static void print(int[] result) {
        System.out.println(GsonUtil.array2Json(Arrays.asList(result)));
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

            deque.offerLast(i);
//            deque.offerFirst();
//            deque.offerLast();

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
}
