package leetcode.t31_100.t78_Subsets;

import utils.GsonUtil;

import java.util.ArrayList;
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
        System.out.println(GsonUtil.array2Json(subsets(new int[] {1, 2, 3})));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int length;
        if (nums == null || (length = nums.length) == 0) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, length, path, result);

        return result;
    }

    private static void dfs(int[] nums, int index, int length, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = index; i < length; i++) {
            Integer integer = nums[i];

            if (!path.contains(integer)) {
                path.add(integer);

                dfs(nums, i + 1, length, path, result);

                path.remove(integer);
            }
        }
    }

}
