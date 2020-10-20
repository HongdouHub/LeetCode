package leetcode.t101_150.t121_122_123_309_188_714_GuPiao;

@SuppressWarnings("all")
public class SuperGuPiao {

    private static final int DEFAULT_COOLDOWN_TIME = 1;

    /**
     * 计算股票买卖获取最大利润 - 【7ms(61.70%) : 37.8MB(99.80%)】
     *
     * @param prices        多天内股票的价格波动
     * @param transaction   股票买卖的交易次数（买 / 卖 各算一次）
     * @return              返回最大利润
     */
    public static int calMaxProfit(int[] prices, int transaction) {
        int length;
        if (prices == null || (length = prices.length) <= 1) {
            return 0;
        }

        if (transaction > length / 2) {
            return calMaxProfitWithoutTransaction(prices);
        }

        // 一次交易包含： 买入 + 卖出各一次交易
        int transactionCount = transaction * 2 + 1;

        // 1. 状态定义：dp[i][j] 表示第i天，至今最多交易了j次下获得的最大利润
        int[][] dp = new int[length][transactionCount];

        // 2. 初始化状态
        for (int j = 1; j < transactionCount; j += 2) {
            dp[0][j] = -prices[0];  // 第一天，买入
        }

//        print(dp);

        // 3. 思考状态转移方程
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < transactionCount; j++) {
                if ((j & 1) == 0) { // 偶数：卖出

                    // 取 Math.max（前一天没有持有股票也不买, 前一天持有股票但卖出股票）
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                } else { // 奇数：买入

                    // 取 Math.max（前一天持有股票但不卖，前一天没有持有股票但买入）
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                }
            }
        }

//        print(dp);

        // 最大值在 dp[length-1] {0...k}中
        int index = length - 1;
        int maxProfit = dp[index][0];

        // 只考虑卖出后
        for (int i = 0; i < transactionCount; i += 2) {
            maxProfit = Math.max(maxProfit, dp[index][i]);
        }
        return maxProfit;
    }

    /**
     * 一次遍历 - 【1ms(98.99%) : 38MB(99.90%)】
     *
     * 时间复杂度：O(n)，遍历了一遍数组。
     * 空间复杂度：O(1)，使用了有限的变量。
     */
    private static int calMaxProfitWithoutTransaction(int[] prices) {
        int length;
        if (prices == null || (length = prices.length) <= 1) {
            return 0;
        }

        int result = 0;
        int minValue = prices[0];
        for (int i = 0; i < length; i++) {
            minValue = Math.min(minValue, prices[i]);

            if (prices[i] > minValue) {
                result += (prices[i] - minValue);
                minValue = prices[i];
            }
        }
        return result;
    }

    /**
     * 计算股票买卖斌且有冷冻期获取最大利润 - 【1ms(99.62%) : 37.3MB(47.62%)】
     *
     * @param prices        多天内股票的价格波动
     * @param transaction   股票买卖的交易次数（买 / 卖 各算一次）
     * @return              返回最大利润
     */
    public static int calMaxProfitWithCooldown(int[] prices, int transaction) {
        int length;
        if (prices == null || (length = prices.length) <= 1) {
            return 0;
        }

        if (transaction > length / 2) {
            return calMaxProfitWithCooldownWithoutTransaction(prices);
        }

        // 一次交易包含： 买入 + 卖出各一次交易
        int transactionCount = transaction * 2 + 1;

        // 1. 状态定义：dp[i][j] 表示第i天，至今最多交易了j次下获得的最大利润
        int[][] dp = new int[length][transactionCount];

        // 2. 初始化状态
        for (int j = 1; j < transactionCount; j += 2) {
            dp[0][j] = -prices[0];  // 第一天，买入
        }
        for (int j = 1; j < transactionCount; j++) {

            if ((j & 1) == 0) { // 偶数：卖出
                dp[1][j] = Math.max(dp[0][j], dp[0][j - 1] + prices[1]);
            } else {            // 奇数：买入
                dp[1][j] = Math.max(dp[0][j], dp[0][j - 1] - prices[1]);
            }
        }

        //print(dp);

        // 3. 思考状态转移方程
        for (int i = 2; i < length; i++) {
            for (int j = 1; j < transactionCount; j++) {
                if ((j & 1) == 0) { // 偶数：卖出

                    // 取 Math.max（前一天没有持有股票也不买, 前一天持有股票但卖出股票）
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                } else {            // 奇数：买入

                    // 取 Math.max（前一天持有股票但不卖，前一天没有持有股票但买入）
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1 - DEFAULT_COOLDOWN_TIME][j - 1] - prices[i]);
                }
            }
        }

        //print(dp);

        // 最大值在 dp[length-1] {0...k}中
        int index = length - 1;
        int maxProfit = dp[index][0];

        // 只考虑卖出后
        for (int i = 0; i < transactionCount; i += 2) {
            maxProfit = Math.max(maxProfit, dp[index][i]);
        }
        return maxProfit;
    }

    /**
     * 一次遍历 - 【1ms(99.62%) : 37.4MB(46.93%)】
     *
     * 时间复杂度：O(n)，遍历了一遍数组。
     * 空间复杂度：O(1)，使用了有限的变量。
     */
    private static int calMaxProfitWithCooldownWithoutTransaction(int[] prices) {
        int length;
        if (prices == null || (length = prices.length) <= 1) {
            return 0;
        }

        // 1. 状态定义：dp[i][j] 表示第i天，当前是（持有/未持有）股票下获得的最大利润
        int[][] dp = new int[length][2];

        // 2. 初始化状态
        dp[0][0] = 0;           // 未持有
        dp[0][1] = -prices[0];  // 持有

        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);    // 未持有
        dp[1][1] = Math.max(-prices[0], -prices[1]);            // 持有

        // 3. 思考状态转移方程
        for (int i = 2; i < length; i++) {
            // 未持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 持有
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1 - DEFAULT_COOLDOWN_TIME][0] - prices[i]);
        }

        return dp[length - 1][0];
    }

    /**
     * 计算股票买卖斌且有冷冻期获取最大利润 - 【21ms(41.54%) : 47.4MB(98.68%)】
     *
     * @param prices        多天内股票的价格波动
     * @param fee           每笔股票的卖出时的交易费用
     * @param transaction   股票买卖的交易次数（买 / 卖 各算一次）
     * @return              返回最大利润
     */
    public static int calMaxProfitWithFee(int[] prices, int fee, int transaction) {
        int length;
        if (prices == null || (length = prices.length) <= 1) {
            return 0;
        }

        if (transaction > length / 2) {
            return calMaxProfitWithFeeWithoutTransaction(prices, fee);
        }

        // 一次交易包含： 买入 + 卖出各一次交易
        int transactionCount = transaction * 2 + 1;

        // 1. 状态定义：dp[i][j] 表示第i天，至今最多交易了j次下获得的最大利润
        int[][] dp = new int[length][transactionCount];

        // 2. 初始化状态
        for (int j = 1; j < transactionCount; j += 2) {
            dp[0][j] = -prices[0];
        }

        // 3. 思考状态转移方程
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < transactionCount; j++) {
                if ((j & 1) == 0) { // 偶数：卖出

                    // 取 Math.max（前一天没有持有股票也不买, 前一天持有股票但卖出股票）
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i] - fee);
                } else { // 奇数：买入

                    // 取 Math.max（前一天持有股票但不卖，前一天没有持有股票但买入）
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                }
            }
        }

        // 最大值在 dp[length-1] {0...k}中
        int index = length - 1;
        int maxProfit = dp[index][0];

        // 只考虑卖出后
        for (int i = 0; i < transactionCount; i += 2) {
            maxProfit = Math.max(maxProfit, dp[index][i]);
        }
        return maxProfit;
    }

    /**
     * 一次遍历 - 【21ms(41.54%) : 47.5MB(97.64%)】
     *
     * 时间复杂度：O(n)，遍历了一遍数组。
     * 空间复杂度：O(1)，使用了有限的变量。
     */
    private static int calMaxProfitWithFeeWithoutTransaction(int[] prices, int fee) {
        int length;
        if (prices == null || (length = prices.length) <= 1) {
            return 0;
        }

        // 1. 状态定义：dp[i][j] 表示第i天，当前是（持有/未持有）股票下获得的最大利润
        int[][] dp = new int[length][2];

        // 2. 初始化状态
        dp[0][0] = 0;           // 未持有
        dp[0][1] = -prices[0];  // 持有

        // 3. 思考状态转移方程
        for (int i = 1; i < length; i++) {
            // 未持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            // 持有
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[length - 1][0];
    }




    /**
     * 计算股票买卖获取最大利润
     *
     * @param prices            多天内股票的价格波动
     * @param transactionCount  股票买卖的交易次数（买 / 卖 各算一次）
     * @return                  返回最大利润
     */
/*    public static int calMaxProfit1(int[] prices, int transactionCount) {
        int length;
        if (prices == null || (length = prices.length) == 0) {
            return 0;
        }

        if (transactionCount > length / 2) {
            return calMaxProfitWithoutTransaction(prices);
        }

        // 1. 状态定义：dp[i][j][k] 表示第i天，至今最多交易了j次，当前在 '持有/未持有' 股票下获得的最大利润
        // 未持有: k = 0    /     持有: k = 1
        int[][][] dp = new int[length][transactionCount + 1][2];

        // 2. 初始化状态
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];

        dp[0][1][0] = 0; // 第0天买入了，不可能不持有股票
        dp[0][1][1] = -prices[0];


        // 3. 思考状态转移方程
        for (int i = 1; i < length; i++) {
//            for (int j = 1; j <= transactionCount; j++) {
            for (int j = transactionCount; j >= 1; j--) {
                // 取 Math.max（前一天没有持有股票也不买, 前一天持有股票但卖出股票）
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);

                // 取 Math.max（前一天持有股票但不卖，前一天没有持有股票但买入）
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        // 最大值在 dp[length-1] {0...k}[0]中
        int index = length - 1;
        int maxProfit = dp[index][0][0];
        for (int i = 0; i <= transactionCount; i++) {
            maxProfit = Math.max(maxProfit, dp[index][i][0]);
        }
        return maxProfit;
    }*/
}
