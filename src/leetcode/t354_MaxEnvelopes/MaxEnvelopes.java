package leetcode.t354_MaxEnvelopes;

import utils.GsonUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，
 * 这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
@SuppressWarnings("all")
public class MaxEnvelopes {

    public static void main(String[] args) {
        int[][] data = new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(data));
    }

    private static int maxEnvelopes(int[][] envelopes) {
        int length;
        if (envelopes == null || (length = envelopes.length) == 0) {
            return 0;
        }

        // 1. 先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    // 对宽度 w 进行升序排序
                    return o1[0] - o2[0];
                } else {
                    // 对相同w的 高度 h 降序排序
                    return o2[1] - o1[1];
                }
            }
        });


        // 2. 之后把所有的 h 作为一个数组，在这个数组上计算 LIS 的长度就是答案。
        int[] dp = new int[length];

        for (int i = 0; i < length; i++) {
            dp[i] = envelopes[i][1];
        }

        // 最长上升子序列求解
        return lengthOfLIS(dp);
    }

    /**
     * 动态规划 - O(N^2)
     * dynamic programmer
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    private static int lengthOfLIS(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }

        // 1. 状态定义，dp[i] 表示 i 个长度的字符中最长子序列的长度
        int[] dp = new int[length + 1];

        // 2. 初始化状态
        Arrays.fill(dp, 1);

        int result = 1;

        // 3. 思考状态转移方程
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
