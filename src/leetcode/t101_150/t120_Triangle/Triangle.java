package leetcode.t101_150.t120_Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形的最小路径和
 */
public class Triangle {

    public static void main(String[] args) {
        int[][] data = new int[][]{
                new int[]{2, 0, 0, 0},
                new int[]{3, 4, 0, 0},
                new int[]{6, 5, 7, 0},
                new int[]{4, 1, 8, 3}
        };

        // 递归
        System.out.println(solveByRecursion(data, 0, 0));

        // 动态规划（用二维数组存储）（时间复杂度：O(m*n)）
        System.out.println(solveByDynamicProgramming1(data));

        // 动态规划（用一维数组存储）（时间复杂度：O(m*n)）
        System.out.println(solveByDynamicProgramming2(data));

        // LeetCode 版本
        System.out.println(solveByDynamicProgramming3(transform(data)));
    }

    /**
     * 递归解题（时间复杂度：O(2^(m*n))）
     */
    private static int solveByRecursion(int[][] data, int row, int col) {
        if (data == null || row >= data.length) return 0;

        if (row == data.length - 1) return data[row][col];

        return Math.min(solveByRecursion(data, row + 1, col),
                solveByRecursion(data, row + 1, col + 1)) + data[row][col];
    }

    /**
     * 动态规划（用二维数组存储）（时间复杂度：O(m*n)）
     */
    private static int solveByDynamicProgramming1(int[][] data) {
        if (data == null) return 0;

        int m = data.length;
        int n = data[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = data[m - 1][i];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + data[i][j];
            }
        }
        return dp[0][0];
    }

    /**
     * 动态规划（用一维数组存储）（时间复杂度：O(m*n)）
     */
    private static int solveByDynamicProgramming2(int[][] data) {
        if (data == null) return 0;

        int m = data.length;
        int n = data[0].length;

        int[] dp = new int[n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + data[i][j];
            }
        }
        return dp[0];
    }

    /**
     * LeetCode 版本
     */
    private static int solveByDynamicProgramming3(List<List<Integer>> triangle) {
        int[] dp = null;
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            if (dp == null) {
                dp = new int[list.size() + 1];
            }
            for (int j = 0; j < list.size(); j++) {
                dp[j] = (Math.min(dp[j], dp[j + 1]) + list.get(j));
            }
        }
        return dp == null ? 0 : dp[0];
    }

    private static List<List<Integer>> transform(int[][] data) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] res : data) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int i : res) {
                if (i != 0) {
                    temp.add(i);
                }
            }
            lists.add(temp);
        }
        return lists;
    }
}
