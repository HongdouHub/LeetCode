package leetcode.t31_100.t90_SubsetsWithDup;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 输入: [1,2,2]
 * 输出: [
 *        [2],
 *        [1],
 *        [1,2,2],
 *        [2,2],
 *        [1,2],
 *        []
 *       ]
 */
public class SubsetsWithDup {

    public void a() {

//        [],
//        [4],
//        [4,4],
//        [4,4,4],
//        [4,4,4,1],
//        [4,4,4,1,4],
//        [4,4,4,4],
//        [4,4,1],*
//        [4,4,1,4],
//        [4,1],
//        [4,1,4],*
//        [1],
//        [1,4]

    }

    public static void main(String[] args) {
//        System.out.println(GsonUtil.array2Json(subsetsWithDup(new int[] {1, 2, 2})));
        System.out.println(GsonUtil.array2Json(subsetsWithDup(new int[] {4, 4, 4, 1, 4})));
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int length;
        if (nums == null || (length = nums.length) == 0) {
            return result;
        }

        List<Integer> path = new ArrayList<>();

        // 关键
        Arrays.sort(nums);
        dfs(nums, 0, length, path, result);

        return result;
    }

    private static void dfs(int[] nums, int index, int length, List<Integer> path, List<List<Integer>> result) {
        if (!result.contains(path)) {
            result.add(new ArrayList<>(path));
        }

        for (int i = index; i < length; i++) {
            Integer integer = nums[i];

//            if (!path.contains(integer)) {
                path.add(integer);

                dfs(nums, i + 1, length, path, result);

                path.remove(integer);
//            }
        }
    }

}
