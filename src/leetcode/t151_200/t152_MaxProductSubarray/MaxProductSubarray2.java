package leetcode.t151_200.t152_MaxProductSubarray;

/**
 * 乘积最大子序列
 *
 * 动态规划（用二维数组存储）（时间复杂度：O(n)）
 */
public class MaxProductSubarray2 {

    public static void main(String[] args) {
        int[] raw = new int[]{-1, -2, -9, -6};
        System.out.println(getMaxValue(raw));
    }

    private static int getMaxValue(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[][] dp = new int[2][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int result = nums[0];

        int x, y;
        for (int i = 1; i < nums.length; i++) {
            x = i % 2;
            y = (i - 1) % 2;

            dp[x][0] = max(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i]);
            dp[x][1] = min(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i]);
            result = Math.max(result, dp[x][0]);
        }
        return result;
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
