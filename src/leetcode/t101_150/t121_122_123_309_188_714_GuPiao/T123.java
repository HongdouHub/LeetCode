package leetcode.t101_150.t121_122_123_309_188_714_GuPiao;

import leetcode.preparation.MethodBuilder;

import static utils.ConsoleUtils.println;

/**
 * 123. 买卖股票的最佳时机 III  -  最多可以完成 两笔 交易
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *      输入: [3,3,5,0,0,3,1,4]
 *      输出: 6
 *      解释: 在第 4 天（股票价格 = 0）的时候买入，
 *            在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *            在第 7 天（股票价格 = 1）的时候买入，
 *            在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 * 示例 2:
 *      输入: [1,2,3,4,5]
 *      输出: 4
 *      解释: 在第 1 天（股票价格 = 1）的时候买入，
 *            在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *            注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *            因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 示例 3:
 *      输入: [7,6,4,3,1]
 *      输出: 0
 *      解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
@SuppressWarnings("all")
public class T123 {

    public static void main(String[] args) {
        test(T123.class, "calMaxProfit");
        test(SuperGuPiao.class, "calMaxProfit");
    }

    private static void test(Class clazz, String methodName) {
        Object o = null;
        try {
            o = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(clazz)
                .setObject(o)
                .setParameterTypes(new Class[]{int[].class, int.class})
                .setMethodName(methodName)
                .build();

        println(String.format("----------%s---------", methodName));
        println(builder.invoke(new int[] {3,3,5,0,0,3,1,4}, 2));  // 3 + 3 = 6
        println(builder.invoke(new int[] {1,2,3,4,5}, 2));        // 4
        println(builder.invoke(new int[] {7,6,4,3,1}, 2));        // 0
        println(builder.invoke(new int[] {7,1,5,3,6,4}, 2));      // 4 + 3 = 7
        println(builder.invoke(new int[] {1,2,4,2,5,7,2,4,9}, 2));// 6 + 7 = 13
        println("---------------------------\n");
    }

    private static int calMaxProfit(int[] prices, int times) {
        int length;
        if (prices == null || (length = prices.length) == 0) {
            return 0;
        }

        int maxProfit = 0;
        int[][] mp = new int[times + 1][length];

        for (int time = 1; time <= times; time++) {
            int tempMax = mp[time - 1][0] - prices[0];

            for (int i = 1; i < length; i++) {
                mp[time][i] = Math.max(mp[time][i - 1], tempMax + prices[i]);
                tempMax = Math.max(tempMax, mp[time - 1][i] - prices[i]);
                maxProfit = Math.max(mp[time][i], maxProfit);
            }
        }
        return maxProfit;
    }
}
