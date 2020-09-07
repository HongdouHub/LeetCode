package leetcode.t31_100.t45_Jump;

import static utils.ConsoleUtils.println;

/**
 * 45. 跳跃游戏 II
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class Jump {

    public static void main(String[] args) {
        println(jump1(new int[]{2, 3, 1, 1, 4}));
        println(jump2(new int[]{2, 3, 1, 1, 4}));
    }

    /**
     * 贪心算法
     * <p>
     * 时间复杂度：O(n)。
     * 空间复杂度：O(1)。
     */
    private static int jump1(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }

        int maxPosition = 0;
        int end = 0;
        int steps = 0;

        for (int i = 0; i < length - 1; i++) {
            // 找能跳的最远的
            maxPosition = Math.max(maxPosition, i + nums[i]);

            // 遇到边界，就更新边界，并且步数加一
            if (end == i) {
                end = maxPosition;
                steps++;

            }
        }

        return steps;
    }

    /**
     * 贪心算法
     * <p>
     * 时间复杂度：O(n^2)。
     * 空间复杂度：O(1)。
     */
    private static int jump2(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }

        int position = length - 1;

        int step = 0;

        //是否到了第 0 个位置
        while (position != 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    // 更新要找的位置
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}
