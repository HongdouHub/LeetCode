package leetcode.t31_100.t77_Combine;

import utils.GsonUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *      输入: n = 4, k = 2
 *      输出: [[2,4],
 *             [3,4],
 *             [2,3],
 *             [1,2],
 *             [1,3],
 *             [1,4]]
 */
@SuppressWarnings("all")
public class Combine {

    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(combine(4, 2)));
    }

    /**
     * 回溯算法
     *
     * 时间复杂度：O()
     * 空间复杂度：O()
     */
    private static List<List<Integer>> combine(int n, int k) {
        if (k > n || k <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        // 优化，将集合改为 双端队列
        Deque<Integer> path = new ArrayDeque<>();

        dfs(n, k, 1, path, result);

        return result;
    }

    private static void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> result) {

        if (k <= path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 优化： 将 n 替换为 n - (k - path.size()) + 1
//        for (int i = index; i <= n; i++) {
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.offer(i);
//            System.out.println("递归之前 => " + GsonUtil.array2Json(path));

            dfs(n, k, i + 1, path, result);

            path.pollLast();
//            System.out.println("递归之前 => " + GsonUtil.array2Json(path));
        }
    }

}
