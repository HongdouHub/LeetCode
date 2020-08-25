package leetcode.t322_CoinChange;

/**
 * 零钱兑换
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5};
        int amount = 11;

        System.out.println(solveByDynamicProgramming(coins, amount));
    }

    private static int solveByDynamicProgramming(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;

        int maxValue = amount + 1;
        int[] dp = new int[maxValue];

        for (int i = 1; i < maxValue; i++) dp[i] = maxValue;

        for (int i = 1; i < maxValue; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}
