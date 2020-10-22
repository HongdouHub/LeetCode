package leetcode.t31_100.t39_CombinationSum;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *     所有数字（包括 target）都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为： [
 *               [7],
 *               [2,2,3]
 *             ]
 */
public class CombinationSum {

    public static void main(String[] args) {
        // [[2,2,3],[7]]
        System.out.println(GsonUtil.array2Json(combinationSum(new int[] {2, 3, 6, 7}, 7)));

        // [[2,2,2,2],[2,3,3],[3,5]]
        System.out.println(GsonUtil.array2Json(combinationSum(new int[] {2, 3, 5}, 8)));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length;
        if (candidates == null || (length = candidates.length) == 0) {
            return result;
        }

        List<Integer> path = new ArrayList<>();

        dfs(candidates, 0, target, length, path, result);

        return result;
    }

    private static void dfs(int[] nums, int sum, int target, int length,
                            List<Integer> path, List<List<Integer>> result) {

        if (sum > target) {
            return;
        } else if (sum == target) {
            List<Integer> temp = new ArrayList<>(path);
            Collections.sort(temp);
            if (!result.contains(temp)) {
                result.add(temp);
            }
            return;
        }

        for (int i = 0; i < length; i++) {

            path.add(nums[i]);
            sum += nums[i];

            dfs(nums, sum, target, length, path, result);

            sum -= nums[i];
            path.remove(path.size() - 1);
        }
    }


}
