package leetcode.t31_100.t62_UniquePaths;

/**
 * 62. 不同路径
 *
 * 走格子，只能向右或向下走
 * <p>
 * 有多少中走法
 * 时间复杂度： O(m*n)
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2)); // 3
        System.out.println(uniquePaths(7, 3)); // 28
    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
