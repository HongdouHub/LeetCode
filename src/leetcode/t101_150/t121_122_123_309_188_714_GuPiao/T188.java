package leetcode.t101_150.t121_122_123_309_188_714_GuPiao;

/**
 * 188. 买卖股票的最佳时机 IV  -   最多可以完成 k 笔交易
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *      输入: [2,4,1], k = 2
 *      输出: 2
 *      解释: 在第 1 天 (股票价格 = 2) 的时候买入，
 *           在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 *
 * 示例 2:
 *      输入: [3,2,6,5,0,3], k = 2
 *      输出: 7
 *      解释: 在第 2 天 (股票价格 = 2) 的时候买入，
 *            在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *            在第 5 天 (股票价格 = 0) 的时候买入，
 *            在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 */
@SuppressWarnings("all")
public class T188 {

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[] {2,4,1}));        // 2
        System.out.println(maxProfit(2, new int[] {3,2,6,5,0,3}));  // 7
    }

    private static int maxProfit(int k, int[] prices) {
        return SuperGuPiao.calMaxProfit(prices, k);
    }
}
