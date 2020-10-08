package leetcode.t31_100.t47_PermuteUnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique2 implements IPermuteUnique {

    @Override
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[length];

        // 关键
        Arrays.sort(nums);
        dfs(nums, 0, length, path, result, used);

        return result;
    }

    private static void dfs(int[] nums, int depth, int length,
                            List<Integer> path, List<List<Integer>> result,
                            boolean[] used) {

        if (depth == length) {
            if (!result.contains(path)) {
                result.add(new ArrayList<>(path));
                return;
            }
        }

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, depth + 1, length, path, result, used);

                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
