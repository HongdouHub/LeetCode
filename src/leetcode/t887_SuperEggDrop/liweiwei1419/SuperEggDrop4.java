package leetcode.t887_SuperEggDrop.liweiwei1419;

import leetcode.t887_SuperEggDrop.AbstractSuperEggDrop;

import java.util.Arrays;

public class SuperEggDrop4 extends AbstractSuperEggDrop {

    /**
     * 动态规划 - 二分法求解
     *
     * @param K 鸡蛋数
     * @param N 楼层数
     *
     * 时间复杂度： O(n * k · log n)
     * 空间复杂度： O(n * k)
     */
    @Override
    public int superEggDrop(int K, int N) {
        int depth = super.superEggDrop(K, N);
        if (depth >= 0) {
            return depth;
        }

        if (K == 1) return N;
        if (N == 0) return 0;

        // 1. 状态定义：dp[i][j] 表示 有i层楼梯（此处i不表示高度），使用j个鸡蛋可以得出的最少实验次数
        // 注意：楼层区间[8, 9, 10]的大小为3
        int[][] dp = new int[N + 1][K + 1];

        // 2. 初始化状态
        for (int i = 0; i <= N; i++) {
            // 由于求的是最小值，因此初始化的时候赋值为一个较大的数，9999 或者 i 都可以
            Arrays.fill(dp[i], i);
        }

        // 第 0 行：楼层为 0 的时候，不管鸡蛋个数多少，都测试不出鸡蛋的 F 值，故全为 0
        Arrays.fill(dp[0], 0);

        // 第 1 行：楼层为 1 的时候，1 个以及 1 个鸡蛋以上只需要扔 1 次
        Arrays.fill(dp[1], 1);
        // 第 1 行：楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次
        dp[1][0] = 0;

        for (int i = 0; i <= N; i++) {
            // 第 0 列：鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0
            dp[i][0] = 0;

            // 第 1 列：鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，
            // 最少次数就等于楼层高度（想想复杂度的定义）
            dp[i][1] = i;
        }

        // 3. 思考状态转移方程：dp[i][j]= （1≤k≤i） min​(max(dp[k−1][j−1], dp[i−k][j]) + 1)
        // 从第 2 行，第 2 列开始填表
        //
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {

                int left = 1;
                int right = i;

                while (left < right) {
                    int middle = left + ((right - left + 1) >> 1);

                    // 碎了
                    int breadCount = dp[middle - 1][j - 1];

                    // 没碎
                    int notBreakCount = dp[i - middle][j];

                    // 求最少实验次数
                    if (breadCount > notBreakCount) {
                        // 求最少实验次数，故向"没碎"靠近
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = middle - 1;
                    } else {
                        // 此处向"碎了"靠近
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = middle;
                    }
                }

                dp[i][j] = Math.max(
                            dp[left - 1][j - 1],
                            dp[i - left][j]
                        ) + 1;
            }
        }

        return dp[N][K];
    }
}
