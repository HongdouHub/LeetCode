package leetcode.t101_150.t121_122_123_309_188_714_GuPiao;

import leetcode.preparation.MethodBuilder;
import leetcode.t101_150.t121_122_123_309_188_714_GuPiao.comm.CommMethod;
import utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

import static utils.ConsoleUtils.print;
import static utils.ConsoleUtils.println;

/**
 * 122. 买卖股票的最佳时机 II  -  多次买卖一支股票
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *      输入: [7,1,5,3,6,4]
 *      输出: 7
 *      解释: 在第 2 天（股票价格 = 1）的时候买入，
 *            在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *            在第 4 天（股票价格 = 3）的时候买入，
 *            在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
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
 *      解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
@SuppressWarnings("all")
public class T122 {

    public static void main(String[] args) {
        // {7, 1, 5, 3, 6, 4}

        test(CommMethod.class, new Class[]{int[].class, int.class});
        test(T122.class, new Class[]{int[].class, int.class});
        test(T122.class, new Class[]{int[].class});
    }

    private static void test(Class clazz, Class[] parameterType) {
        Object o = null;
        try {
            o = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(clazz)
                .setObject(o)
                .setParameterTypes(parameterType)
                .setMethodName("calMaxProfit")
                .build();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < parameterType.length; i++) {
            list.add(parameterType[i].getSimpleName());
        }

        println(String.format("--------------%s------------", clazz.getSimpleName()));
        print(String.format("%s#calMaxProfit(%s) = ", clazz.getSimpleName(), GsonUtil.array2Json(list)));

        if (parameterType.length == 1) {
            println(builder.invoke(new int[] {7, 1, 5, 3, 6, 4}));      // 4 + 3 = 7
        } else {
            println(builder.invoke(new int[] {7, 1, 5, 3, 6, 4}, 2));   // 4 + 3 = 7
        }
        println("-----------------------------------\n");
    }

    private static int calMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;

        for (int price : prices) {
            release2 = Math.max(release2, hold2 + price);
            hold2 = Math.max(hold2, release1 - price);

            release1 = Math.max(release1, hold1 + price);
            hold1 = Math.max(hold1, -price);
        }

        return release2;
    }

    private static int calMaxProfit(int[] prices, int times) {
        int size;
        if (prices == null || (size = prices.length) == 0) return 0;

        // max_profit[i][j][k]
        // i : 数组长度为 i
        // j : 当前交易了 j 次（买入和卖出）
        // k : 当前是否持有股票（0：没有股票； 1：持有股票）
        int[][][] mp = new int[size][times * 2][2];

        mp[0][0][0] = 0;
        mp[0][0][1] = -prices[0];

        mp[0][1][0] = Integer.MIN_VALUE;
        mp[0][1][1] = Integer.MIN_VALUE;

        mp[0][2][0] = Integer.MIN_VALUE;
        mp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            mp[i][0][0] = mp[i - 1][0][0];
            mp[i][0][1] = Math.max(mp[i - 1][0][1], mp[i - 1][0][0] - prices[i]);

            mp[i][1][0] = Math.max(mp[i - 1][1][0], mp[i - 1][0][1] + prices[i]);
            mp[i][1][1] = Math.max(mp[i - 1][1][1], mp[i - 1][1][0] - prices[i]);

            mp[i][2][0] = Math.max(mp[i - 1][2][0], mp[i - 1][1][1] + prices[i]);
            mp[i][2][1] = Math.max(mp[i - 1][2][1], mp[i - 1][1][0] - prices[i]);

            mp[i][3][0] = Math.max(mp[i - 1][3][0], mp[i - 1][2][1] + prices[i]);
        }
        int end = prices.length - 1;
//        return max(mp[end][0][0], mp[end][1][0], mp[end][2][0], mp[end][3][0]);
        return Math.max(Math.max(mp[end][0][0], mp[end][1][0]), mp[end][2][0]);
    }

    private static int max(int... data) {
        int result = Integer.MIN_VALUE;
        for (int d : data) {
            if (d > result) {
                result = d;
            }
        }
        return result;
    }
}
