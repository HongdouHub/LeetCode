package leetcode.t31_100.t46_Permute;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 输入: [1,2,3]
 * 输出:
 *      [
 *        [1,2,3],
 *        [1,3,2],
 *        [2,1,3],
 *        [2,3,1],
 *        [3,1,2],
 *        [3,2,1]
 *      ]
 */
@SuppressWarnings("all")
public class Permute {

    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(permute(new int[] {1, 2, 3})));
    }

    /**
     * 回溯算法
     *
     * 时间复杂度：O(N × N!)
     * 空间复杂度：O(N × N!)
     */
    private static List<List<Integer>> permute(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[length];
        List<Integer> path = new ArrayList<>();

        dfs(nums, length, 0, path, used, result);
        return result;
    }

    private static void dfs(int[] nums, int length, int depth,
                            List<Integer> path, boolean[] used, List<List<Integer>> result) {

        if (depth == length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 在非叶子结点处，产生不同的分支，
        // 这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < length; i++) {
            if (!used[i]) {

                path.add(nums[i]);
                used[i] = true;
//                System.out.println("  递归之前 => " + GsonUtil.array2Json(path));

                // 注意：下面这两行代码发生 「回溯」，
                // 回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                dfs(nums, length, depth + 1, path, used, result);

                path.remove(path.size() - 1);
                used[i] = false;
//                System.out.println(" #递归之后 => " + GsonUtil.array2Json(path));
            }
        }
    }

}
