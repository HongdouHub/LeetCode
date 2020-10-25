package leetcode.t31_100.t63_UniquePathsWithObstacles;

import static utils.ConsoleUtils.println;

/**
 * 63. 不同路径 II
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *      输入:
 *          [
 *            [0,0,0],
 *            [0,1,0],
 *            [0,0,0]
 *          ]
 *      输出: 2
 *      解释:
 *          3x3 网格的正中间有一个障碍物。
 *          从左上角到右下角一共有 2 条不同的路径：
 *          1. 向右 -> 向右 -> 向下 -> 向下
 *          2. 向下 -> 向下 -> 向右 -> 向右
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        println(uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 1, 0, 0, 0, 1, 0},
                new int[]{0, 0, 0, 0, 1, 0, 0, 0},
                new int[]{1, 0, 1, 0, 0, 1, 0, 0},
                new int[]{0, 0, 1, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 1, 1, 0, 1, 0},
                new int[]{0, 1, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0}
        })); // 27

        println(uniquePathsWithObstacles(new int[][]{
                new int[]{1}
        })); // 0

        println(uniquePathsWithObstacles(new int[][]{
                new int[]{1, 0}
        })); // 0

        println(uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0}
        })); // 1

        println(uniquePathsWithObstacles(new int[][]{
                new int[]{0, 1}
        })); // 0

        println(uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0},
                new int[]{0, 1}
        })); // 0

        println(uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0},
                new int[]{1, 0}
        })); // 1

        println(uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0},
                new int[]{1, 1},
                new int[]{0, 0}
        })); // 0
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 1) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[0][j] == 1) {
                    return 0;
                }
            }
        }

        if (n == 1) {
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] == 1) {
                    return 0;
                }
            }
        }

        if (m != 1 && n != 1 && obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        boolean[][] translate = translate(obstacleGrid);
        return countPaths(translate);
    }

    /**
     * 翻转二维数组
     */
    private static boolean[][] translate(int[][] raw) {
        int m = raw.length;
        int n = raw[0].length;

        // 旋转前的数组
        boolean[][] temp = new boolean[m][n];
        // 旋转后的数组
        boolean[][] board = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = (raw[i][j] != 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = temp[m - 1 - i][n - 1 - j];
            }
        }
        return board;
    }

    private static int countPaths(boolean[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] dp = new int[m][n];

        boolean preReachable = true;
        for (int i = 0; i < m; i++) {
            dp[i][0] = (board[i][0] || (preReachable = false)) ?
                    (preReachable ? 1 : 0) : 0;
        }

        preReachable = true;
        for (int j = 0; j < n; j++) {
            dp[0][j] = (board[0][j] || (preReachable = false)) ?
                    (preReachable ? 1 : 0) : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j]) { // 是空地，可达
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else { // 是石头，不可达
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
