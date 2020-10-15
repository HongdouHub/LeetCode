package leetcode.t101_150.t121_122_123_309_188_714_GuPiao;

import leetcode.t101_150.t121_122_123_309_188_714_GuPiao.comm.CommMethod;

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

        System.out.println(CommMethod.calMaxProfit(raw, 1));
        System.out.println(calMaxProfit(raw));
//        System.out.println(CommMethod.calMaxProfit(raw, 1));
    }

    private static int calMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minValue = prices[0];
        int result = 0;

        for (int price : prices) {
            if (minValue > price) {
                minValue = price;
            }

            System.out.println("比较前：" + result);
            if (result < price - minValue) {
                result = price - minValue;
            }
            System.out.println("比较后：" + result);
            System.out.println();
        }
        return result;
    }

}
