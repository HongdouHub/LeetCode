package leetcode.t312_MaxCoins;

import java.util.Arrays;

/**
 * 312. 戳气球
 *
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，
 * 就可以获得 nums[left] * nums[i] * nums[right] 个硬币。
 * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。
 * 注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *     你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 *     0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * 示例:
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5    +   3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class MaxCoins {

    public static void main(String[] args) {
        System.out.println(maxCoins1(new int[] {3, 1, 5, 8}));
        System.out.println(maxCoins2(new int[] {3, 1, 5, 8}));
    }

    /**
     * 记忆化搜索
     *
     * 时间复杂度：O(N^3)
     * 空间复杂度：O(n^2)
     */
    private static int maxCoins1(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length + 2];
        int[][] result = new int[length + 2][length + 2];

        System.arraycopy(nums, 0, temp, 1, length);
        temp[0] = temp[length + 1] = 1;

        for (int i = 0; i < length + 2; i++) {
            Arrays.fill(result[i], -1);
        }

        return solve(0, length + 1, temp, result);
    }

    /**
     * solve(i,j) 表示 将开区间 (i,j) 内的位置全部填满气球能够得到的最多硬币数
     *
     * 当 i ≥ j−1 时，开区间中没有气球，solve(i,j) 的值为 0；
     *
     * 当 i < j−1 时，我们枚举开区间 (i,j) 内的全部位置 mid，
     * 令 mid 为当前区间第一个添加的气球，该操作能得到的硬币数为 val[i]×val[mid]×val[j]
     *
     * 同时我们递归地计算分割出的两区间对 solve(i,j) 的贡献，
     * 这三项之和的最大值，即为 solve(i,j) 的值
     */
    private static int solve(int left, int right, int[] nums , int[][] result) {
        if (left >= right - 1) {
            return 0;
        }

        // 剪枝
        if (result[left][right] != -1) {
            return result[left][right];
        }

        for (int i = left + 1; i < right; i++) {

            int sum = nums[left] * nums[i] * nums[right];
            sum += solve(left, i, nums, result) + solve(i, right, nums, result);
            result[left][right] = Math.max(result[left][right], sum);
        }

        return result[left][right];
    }

    /**
     * 动态规划
     *
     * 时间复杂度：O(N^3)
     * 空间复杂度：O(n^2)
     */
    private static int maxCoins2(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }

        int[] value = new int[length + 2];
        System.arraycopy(nums, 0, value, 1, length);
        value[0] = value[length + 1] = 1;

        // 1. 状态定义，填满开区间 (i,j)能得到的最多硬币数
        int[][] dp = new int[length + 2][length + 2];

        // 2. 初始化状态
//        for (int i = 0; i < length + 2; i++) {
//            Arrays.fill(dp[i], -1);
//        }

        // 3. 思考状态转移方程
        for (int i = length - 1; i >= 0; i--) {

            for (int j = i + 2; j < length + 2; j++) {

                for (int k = i + 1; k < j; k++) {

                    int sum = value[i] * value[k] * value[j];
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + sum + dp[k][j]);
                }
            }
        }

        return dp[0][length + 1];
    }
}
