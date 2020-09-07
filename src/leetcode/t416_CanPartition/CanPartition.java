package leetcode.t416_CanPartition;

/**
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。
 * 是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *     每个数组中的元素不会超过 100
 *     数组的大小不会超过 200
 *
 *
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 */
public class CanPartition {

    public static void main(String[] args) {
        System.out.println(canPartition1(new int[] {1, 5, 11, 5}));
        System.out.println(canPartition1(new int[] {1, 2, 3, 5}));
        System.out.println(canPartition1(new int[] {2, 2, 3, 5}));

        System.out.println(canPartition2(new int[] {1, 5, 11, 5}));
        System.out.println(canPartition2(new int[] {1, 2, 3, 5}));
        System.out.println(canPartition2(new int[] {2, 2, 3, 5}));
    }

    /**
     * 动态规划
     *
     * 时间复杂度：O(NC)：这里 N 是数组元素的个数，C 是数组元素的和的一半。
     * 空间复杂度：O(NC)
     */
    private static boolean canPartition1(int[] nums) {

        int length;
        if (nums == null || (length = nums.length) == 0) {
            return false;
        }

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 总和为奇数
        if ((totalSum & 1) != 0) {
            return false;
        }

        int target = totalSum / 2;

        // 1. 状态定义： dp[i][j] 表示前i个物品可以恰好放到一个容量为j的背包
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[length][target + 1];

        // 2. 初始化状态
        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满

        // 初始化成为 true 虽然不符合状态定义，但是从状态转移来说是完全可以的
        dp[0][0] = true;

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // 3. 思考状态转移方程
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[length - 1] [target];
    }

    /**
     * 动态规划 + 滚动数组
     *
     * 时间复杂度：O(NC)：这里 N 是数组元素的个数，C 是数组元素的和的一半。
     * 空间复杂度：O(C)
     */
    private static boolean canPartition2(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return false;
        }

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 总和为奇数
        if ((totalSum & 1) != 0) {
            return false;
        }

        int target = totalSum / 2;

        // 1. 状态定义： dp[i][j] 表示前i个物品可以恰好放到一个容量为j的背包
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[] dp = new boolean[target + 1];


        // 2. 初始化状态
        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满

        // 初始化成为 true 虽然不符合状态定义，但是从状态转移来说是完全可以的
        dp[0] = true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }

        // 3. 思考状态转移方程
        for (int i = 1; i < length; i++) {
            for (int j = target; j >= 0; j--) {

               if (dp[target]) {
                    return true;
                }

                if (nums[i] <= j) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }

        return dp[target];
    }

}
