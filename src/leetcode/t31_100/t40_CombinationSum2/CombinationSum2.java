package leetcode.t31_100.t40_CombinationSum2;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 40. 组合总和 II
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为: [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        // [[1,2,5],[1,7],[1,1,6],[2,6]]
        System.out.println(GsonUtil.array2Json(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)));

        // [[1,2,2],[5]]
        System.out.println(GsonUtil.array2Json(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5)));

    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length;
        if (candidates == null || (length = candidates.length) == 0) {
            return result;
        }

        List<Integer> path = new ArrayList<>();

        dfs(candidates, 0, target, 0, length, path, result);

        return result;
    }

    private static void dfs(int[] nums, int sum, int target, int index, int length,
                            List<Integer> path, List<List<Integer>> result) {

        if (sum == target) {
            List<Integer> temp = new ArrayList<>(path);
            Collections.sort(temp);
            if (!result.contains(temp)) {
                result.add(temp);
            }
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = index; i < length; i++) {
            path.add(nums[i]);
            sum += nums[i];

            dfs(nums, sum, target, i + 1, length, path, result);

            sum -= nums[i];
            path.remove(path.size() - 1);
        }

    }

}
