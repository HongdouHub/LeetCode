package leetcode.t451_650.t518_CoinChange;

import leetcode.preparation.MethodBuilder;
import leetcode.preparation.array.PrepareArray;

import static utils.ConsoleUtils.println;

/**
 * 518. 零钱兑换 II  -  硬币组合数
 * <p>
 * 给定不同面额的硬币和一个总金额。
 * 写出函数来计算可以凑成总金额的硬币组合数。
 * 假设每一种面额的硬币有无限个。
 *
 * 示例 1:
 *      输入: amount = 5, coins = [1, 2, 5]
 *      输出: 4
 *      解释: 有四种方式可以凑成总金额:
 *              5=5
 *              5=2+2+1
 *              5=2+1+1+1
 *              5=1+1+1+1+1
 *
 * 示例 2:
 *      输入: amount = 3, coins = [2]
 *      输出: 0
 *      解释: 只用面额2的硬币不能凑成总金额3。
 *
 * 示例 3:
 *      输入: amount = 10, coins = [10]
 *      输出: 1
 */
@SuppressWarnings("all")
public class CoinChange {

    private static final boolean DEBUG = false;

    public static void main(String[] args) {
        test("change1");
        test("change2");
    }

    private static void test(String methodName) {
        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(CoinChange.class)
                .setMethodName(methodName)
                .setParameterTypes(new Class[]{int.class, int[].class})
                .build();

        println(builder.invoke(5, new int[]{1, 2, 5}));   // 4
        println(builder.invoke(3, new int[]{2}));         // 0
        println(builder.invoke(10, new int[]{10}));       // 1
        println("----------------------");
    }

    /**
     * 动态规划
     * <p>
     * 时间复杂度：O(N · M ^ 2)
     * 空间复杂度：O(N · M)
     */
    private static int change1(int amount, int[] coins) {
        int length;
        if (coins == null || (length = coins.length) == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int maxValue = amount + 1;

        // 1. 状态定义，dp[i][j] 表示总金额为 j 下，硬币列表的前缀子区间 [0, i] 能够凑成的最大组合数。
        int[][] dp = new int[maxValue][length];
        print(dp, "amount", "length");

        // 2. 初始化状态
        dp[0][0] = 1;
        print(dp, "amount", "length");

        for (int i = coins[0]; i < maxValue; i += coins[0]) {
            dp[i][0] = 1;
            print(dp, "amount", "length");
        }

        // 3. 思考状态转移方程

        // 遍历总金额
        for (int i = 0; i < maxValue; i++) {

            // 遍历硬币的种类
            for (int j = 1; j < length; j++) {

                // 遍历组合数
                for (int k = 0; i - k * coins[j] >= 0; k++) {
                    dp[i][j] += dp[i - k * coins[j]][j - 1];
                }
            }
        }

        return dp[amount][length - 1];
    }

    /**
     * 动态规划
     * <p>
     * 时间复杂度：O(N · M ^ 2)
     * 空间复杂度：O(N · M)
     */
    private static int change2(int amount, int[] coins) {
        int length;
        if (coins == null || (length = coins.length) == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int maxValue = amount + 1;

        // 1. 状态定义，dp[i][j] 表示硬币列表的前缀子区间 [0, i] 能够凑成总金额为 j 的组合数。
        int[][] dp = new int[length][maxValue]; // length: 3   amount: 6
        print(dp, "length", "amount");

        // 2. 初始化状态
        dp[0][0] = 1;
        print(dp, "length", "amount");

        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
            print(dp, "length", "amount");
        }

        // 3. 思考状态转移方程

        // 遍历硬币的种类
        for (int i = 1; i < length; i++) {

            // 遍历总金额
            for (int j = 0; j < maxValue; j++) {

                // 遍历组合数
                // dp[i][j] 相对于 dp[i - 1][j] 而言，多考虑的一枚硬币，
                // 是当前正在考虑的那枚硬币的面值，coins[i]，
                // 而这枚硬币选取的个数（从 000 开始）就是
                // dp[i][j] 这个问题可以分解的各个子问题的分类标准。
                for (int k = 0; j - k * coins[i] >= 0; k++) {
//                    System.out.println(String.format("dp[%d][%d] += dp[%d][%d];", i, j, i - 1, j - k * coins[i]));
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                    print(dp, "length", "amount");
                }
            }
        }

        return dp[length - 1][amount];
    }

    private static void print(int[][] dp, String xName, String yName) {
        if (DEBUG) {
            PrepareArray.print(dp, xName, yName);
        }
    }

}
