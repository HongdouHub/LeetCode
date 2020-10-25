package leetcode.t31_100.t78_Subsets;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出: [
 *         [3],
 *         [1],
 *         [2],
 *         [1,2,3],
 *         [1,3],
 *         [2,3],
 *         [1,2],
 *         []
 *       ]
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(subsets1(new int[] {1, 2, 3})));
        System.out.println(GsonUtil.array2Json(subsets2(new int[] {1, 2, 3})));
    }

    /**
     * 回溯算法 - 【2ms(26.16%) - 38.4MB(99.08%)】
     */
    private static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        dfs1(nums, 0, length, path, result);
        return result;
    }

    private static void dfs1(int[] nums, int index, int length,
                             List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = index; i < length; i++) {
            Integer integer = nums[i];

            if (!path.contains(integer)) {
                path.add(integer);

                dfs1(nums, i + 1, length, path, result);

                path.remove(integer);
            }
        }
    }

    /**
     * 回溯算法 - 优化 【1ms(99.43%) - 38.7MB(95.13%)】
     */
    private static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int length;
        if (nums == null || (length = nums.length) == 0) {
            return result;
        }

        // 优化，双端队列
        Deque<Integer> path = new LinkedList<>();
        dfs2(nums, 0, length, path, result);

        return result;
    }

    private static void dfs2(int[] nums, int index, int length,
                            Deque<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = index; i < length; i++) {
            if (!path.contains(nums[i])) {
                path.offer(nums[i]);

                dfs2(nums, i + 1, length, path, result);

                path.pollLast();
            }
        }
    }

}
