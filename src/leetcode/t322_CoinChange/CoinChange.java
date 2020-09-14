package leetcode.t322_CoinChange;

import java.util.Arrays;

/**
 * 322. 零钱兑换 - 最少的硬币个数
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
@SuppressWarnings("all")
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(solveByDynamicProgramming(new int[] {1, 2, 5}, 11)); // 3
        System.out.println(solveByDynamicProgramming(new int[] {2}, 3));        // -1
    }

    private static int solveByDynamicProgramming(int[] coins, int amount) {
        int length;
        if (coins == null || (length = coins.length) == 0) {
            return -1;
        }

        int maxValue = amount + 1;

        // 1.状态定义：dp[i] 表示总金额为i时，所需的最少的硬币个数
        int[] dp = new int[maxValue];

        // 2.初始化状态
        Arrays.fill(dp, maxValue);
        dp[0] = 0;

//        for (int i = 1; i < maxValue; i++) dp[i] = maxValue;

        // 3. 思考状态转移方程

        // 遍历总金额
        for (int i = 0; i < maxValue; i++) {

            // 遍历硬币的种类
            for (int j = 0; j < length; j++) {

                // 总金额肯定要大于单枚硬币的额度
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // 给定的默认值就是: 总金额+1
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
