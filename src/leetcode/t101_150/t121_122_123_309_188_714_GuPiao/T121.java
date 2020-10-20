package leetcode.t101_150.t121_122_123_309_188_714_GuPiao;

import static utils.ConsoleUtils.println;

/**
 * 121. 买卖股票的最佳时机 - 最多只允许完成一笔交易
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *      输入: [7,1,5,3,6,4]
 *      输出: 5
 *      解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，
 *            最大利润 = 6-1 = 5 。 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；
 *            同时，你不能在买入前卖出股票。
 *
 * 示例 2:
 *      输入: [7,6,4,3,1]
 *      输出: 0
 *      解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class T121 {

    public static void main(String[] args) {
        int[] raw = new int[] {7, 1, 5, 3, 6, 4};

        println(calMaxProfit1(raw));
        println(calMaxProfit2(raw));
        println(SuperGuPiao.calMaxProfit(raw, 1));
    }

    /**
     * 一次遍历 - 【1ms(98.99%) : 38MB(99.90%)】
     *
     * 时间复杂度：O(n)，遍历了一遍数组。
     * 空间复杂度：O(1)，使用了有限的变量。
     */
    private static int calMaxProfit1(int[] prices) {
        int length;
        if (prices == null || (length = prices.length) == 0) {
            return 0;
        }

        int minValue = prices[0];
        int result = 0;

        for (int i = 0; i < length; i++) {

            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (prices[i] > minValue) {
                result = Math.max(result, prices[i] - minValue);
            }
        }
        return result;
    }

    /**
     * 动态规划 - 【6ms(20.80%) : 39.9MB(5.28%)】
     * 时间复杂度：O(n)，遍历了一遍数组。
     * 空间复杂度：O(n)
     */
    private static int calMaxProfit2(int[] prices) {
        int length;
        if (prices == null || (length = prices.length) == 0) {
            return 0;
        }

        // 1. 状态定义： dp[i][j] 表示第 i 天，当前在（保持未买/买入/卖出）下获得的最大利润
        int[][] dp = new int[length][3];

        // 2. 初始化状态
        dp[0][0] = 0;               // 保持未买
        dp[0][1] = -prices[0];      // 买入
        dp[0][2] = 0;               // 卖出

        int result = 0;

        // 3. 思考状态转移方程
        for (int i = 1; i < length; i++) {

            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);

            result = max(result, dp[i][0], dp[i][1], dp[i][2]);
        }

        return result;
    }

    private static int max(int... data) {
        int length = data.length;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            result = Math.max(result, data[i]);
        }
        return result;
    }

}
