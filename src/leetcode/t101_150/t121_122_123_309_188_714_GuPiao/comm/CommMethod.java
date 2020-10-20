package leetcode.t101_150.t121_122_123_309_188_714_GuPiao.comm;

public class CommMethod {

    public static void main(String[] args) {
        int[] raw = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(calMaxProfit(raw, 2));
    }

    public static int calMaxProfit(int[] prices, int times) {
        int length;
        if (prices == null || (length = prices.length) == 0) {
            return 0;
        }

        // max_profit[i][j][k]
        // i : 数组长度为 i
        // j : 当前交易了 j 次（买入和卖出）
        // k : 当前是否持有股票（0：没有股票； 1：持有股票）
        int[][][] mp = new int[length][times][2];

        mp[0][0][0] = 0;
        mp[0][0][1] = -prices[0];
        mp[1][0][0] = 0;
        mp[1][0][1] = -prices[1];

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < times; j++) {
                for (int k = 0; k < 2; k++) {

                    if (k == 0) {
                        // 前一天不动 || 前一天卖出股票
                        mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j - 1][1] + prices[i]);

                    } else {
                        // 前一天不动 || 前一天买出股票
                        mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
                    }
                }
            }
        }

        int maxValue = mp[length - 1][0][0];
        for (int j = 0; j < times; j++) {
            if (maxValue < mp[length - 1][j][0]) {
                maxValue = mp[length - 1][j][0];
            }
        }
        return maxValue;

    }

}
