package leetcode.t201_250.t213_Rob;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 */
public class Rob {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }

    private static int rob(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[0];
        }

        return Math.max(myRob(Arrays.copyOfRange(nums, 0, length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, length)));
    }

    private static int myRob(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[0];
        }

        // 1. 状态定义，dp[i]表示第i次获得的最大金额
        int[] dp = new int[length];

        // 2. 初始化状态
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 3. 思考状态转移方程
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[length - 1];
    }
}
