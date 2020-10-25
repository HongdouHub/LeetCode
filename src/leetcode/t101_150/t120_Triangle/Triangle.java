package leetcode.t101_150.t120_Triangle;

import leetcode.preparation.MethodBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static utils.ConsoleUtils.println;

/**
 * 120. 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class Triangle {

    public static void main(String[] args) {
        test("minimumTotal1");
        test("minimumTotal2");
        test("minimumTotal3");
    }

    private static void test(String methodName) {
        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(Triangle.class)
                .setMethodName(methodName)
                .setParameterTypes(List.class)
                .build();

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(String.format("-------------%s------------", methodName));
        println(builder.invoke(triangle));  // 11
        System.out.println("----------------------------------------\n");
    }

    /**
     * 递归 - 超时
     *
     * 时间复杂度：O(2^(m*n))
     * 空间复杂度：O(log n)
     */
    private static int minimumTotal1(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private static int dfs(List<List<Integer>> triangle, int row, int col) {
        int m;
        if (triangle == null || row >= (m = triangle.size())) {
            return 0;
        }

        if (row == m - 1) {
            return triangle.get(row).get(col);
        }

        return triangle.get(row).get(col) + Math.min(
                dfs(triangle, row + 1, col),
                dfs(triangle, row + 1, col + 1)
        );
    }

    /**
     * 动态规划 - 【2ms(95.22%) - 38.3MB(97.20%)】
     *
     * 时间复杂度：O(mn), m是行数,n是列数
     * 空间复杂度：O(mn)
     */
    private static int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null) return 0;

        int m = triangle.size();
        int n = triangle.get(m - 1).size();

        // 1. 状态定义：dp[i][j] 表示从根节点出发，到第i行第j列节点时，最小的路径和
        int[][] dp = new int[m][n];

        // 2. 初始化状态
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = triangle.get(m - 1).get(j);
        }

        // 3. 思考状态转移方程
        for (int i = m - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[i][j] = list.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    /**
     * 动态规划（用一维数组存储） - 【2ms(95.22%) - 38.7MB(89.10%)】
     *
     * 时间复杂度：O(m*n), m是行数,n是列数
     * 空间复杂度：O(n)
     */
    private static int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle == null) return 0;

        int m = triangle.size();
        int n = triangle.get(m - 1).size();

        // 1. 状态定义： dp[i] 表示第i列（叶子节点一层）下，最小的路径和
        // 多加一层是为了从0开始算
        int[] dp = new int[n + 1];

        // 2. 初始化状态

        // 3. 思考状态转移方程
        // 从底部一层向上遍历
        for (int i = m - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                // 自底向上遍历，对比找出下一层最小值 + 当前位置的值
                dp[j] = list.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}
