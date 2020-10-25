package leetcode.t801_1200.t877_StoneGame;

import leetcode.preparation.MethodBuilder;

import java.util.Arrays;

/**
 * 877. 石子游戏
 *
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。
 * 每回合，玩家从行的开始或结束处取走整堆石头。
 * 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 *
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 * 示例：
 *      输入：[5,3,4,5]
 *      输出：true
 *      解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 */
@SuppressWarnings("all")
public class StoneGame {

    public static void main(String[] args) {
        test("stoneGame1");
        test("stoneGame2");
        test("stoneGame3");
    }

    private static void test(String methodName) {
        MethodBuilder build = new MethodBuilder.Builder()
                .setClazz(StoneGame.class)
                .setParameterTypes(new Class[]{int[].class})
                .setMethodName(methodName)
                .build();

        System.out.println(String.format("-------------------%s------------------", methodName));
        System.out.println(build.invoke(new int[] {5, 3, 4, 5}));
        System.out.println(build.invoke(new int[] {3, 2, 10, 4}));
        System.out.println("-----------------------------------------------\n");
    }

    /**
     * 数学方式
     *
     * 1、石子的总数是奇数
     * 2、石子堆的总数是偶数
     * 3、Alex 是先手，
     *
     * 推导： Alex 必胜（没有平局）的必要条件。
     */
    private static boolean stoneGame1(int[] piles) {
        return true;
    }

    /**
     * 动态规划
     *
     * 时间复杂度： O(n ^ 2)
     * 空间复杂度： O(n ^ 2)
     */
    private static boolean stoneGame2(int[] piles) {

        int length = piles.length;

        // 1. 状态定义：dp[i][j]表示以第i个石子为起始，以第j个石子为结束位置时先手的最高得分。
        int[][] dp = new int[length][length];

        // 2. 初始化状态
        for (int i = 0; i < length; i++) {
            // 由于是相对分数，有可能是在负值里面选较大者，因此初始化的时候不能为 0
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            dp[i][i] = piles[i];
        }

        // 3. 思考状态转移方程
        for (int j = 1; j < length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int chooseLeft = piles[i] - dp[i + 1][j];
                int chooseRight = piles[j] - dp[i][j - 1];
                dp[i][j] = Math.max(chooseLeft, chooseRight);
            }
        }

        return dp[0][length - 1] > 0;
    }

    /**
     * 记忆化递归 + 相对分数
     *
     * 相对分数： 我作为先手，得分是正分，而队手得分与我而言是负分
     */
    private static boolean stoneGame3(int[] piles) {
        int length = piles.length;
        int[][] memory = new int[length][length];

        for (int i = 0; i < length; i++) {
            // 由于是相对分数，有可能是在负值里面选较大者，因此初始化的时候不能为 0
            Arrays.fill(memory[i], Integer.MIN_VALUE);
            memory[i][i] = piles[i];
        }

        return dfs(piles, 0, length - 1, memory) > 0;
    }

    /**
     * 计算子区间 [left, right] 里先手能够得到的分数
     */
    private static int dfs(int[] piles, int left, int right, int[][] memory) {
        if (left == right) {
            return piles[left];
        }

        if (memory[left][right] != Integer.MIN_VALUE) {
            return memory[left][right];
        }

        int chooseLeft = piles[left] - dfs(piles, left + 1, right, memory);
        int chooseRight = piles[right] - dfs(piles, left, right - 1, memory);

//        System.out.println(String.format("chooseLeft:%s chooseRight:%s", chooseLeft, chooseRight));
        memory[left][right] = Math.max(chooseLeft, chooseRight);
        return memory[left][right];
    }

}
