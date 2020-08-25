package leetcode.t101_150.t121_122_123_309_188_714_GuPiao.t121_122_123_188;

public class t122 {
    public static final String PRINT = "%35s: %d";

    public static void main(String[] args) {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        // 4 + 3 = 7

        System.out.println(String.format(PRINT, "CommMethod.calMaxProfit",
                CommMethod.calMaxProfit(prices, 2)));

        System.out.println(String.format(PRINT, "calMaxProfit",
                calMaxProfit(prices, 2)));

        System.out.println(String.format(PRINT, "calMaxProfitByDynamicProgramming",
                calMaxProfitByDynamicProgramming(prices, 2)));

        System.out.println(String.format(PRINT, "calMaxProfit",
                calMaxProfit(prices)));
    }

    private static int calMaxProfit(int[] prices, int times) {
        return 0;
    }

    private static int calMaxProfitByDynamicProgramming(int[] prices, int times) {
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
        return max(mp[end][0][0], mp[end][1][0], mp[end][2][0], mp[end][3][0]);
//        return Math.max(Math.max(mp[end][0][0], mp[end][1][0]), mp[end][2][0]);
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
