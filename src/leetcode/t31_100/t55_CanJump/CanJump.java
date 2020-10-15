package leetcode.t31_100.t55_CanJump;

import leetcode.preparation.MethodBuilder;

/**
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * <p>
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ，
 * 所以你永远不可能到达最后一个位置。
 */
@SuppressWarnings("all")
public class CanJump {

    public static void main(String[] args) {
        test("canJump1");
        test("canJump2");
        test("canJump3");
    }

    private static void test(String methodName) {
        MethodBuilder build = new MethodBuilder.Builder()
                .setClazz(CanJump.class)
                .setMethodName(methodName)
                .setParameterTypes(new Class[]{int[].class})
                .build();

        System.out.println(String.format("----------%s---------", methodName));
        System.out.println(build.invoke(new int[]{2, 3, 1, 1, 4}));         // true
        System.out.println(build.invoke(new int[]{3, 2, 1, 0, 4}));         // false
//        System.out.println(build.invoke(TEST));                             // false
        System.out.println(build.invoke(new int[]{1, 1, 1, 0, 4, 5, 6}));   // false
        System.out.println("---------------------------\n");
    }

    private static final int[] TEST = new int[] {
            8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0,
            8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6,
            0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1,
            7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1,
            0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2,
            5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8,
            5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5
    };

    /**
     * 贪心算法
     * 从当前位置能够到达某一个位置，那么从当前位置都可以到达某一位置左侧的所有位置。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean canJump1(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return false;
        }

        int maxValue = 0;
        for (int i = 0; i < length; i++) {
            if (i > maxValue) {
                return false;
            }

            maxValue = Math.max(maxValue, i + nums[i]);
        }
        return true;
    }

    /**
     * 贪心算法 - 优化
     * 从当前位置能够到达某一个位置，那么从当前位置都可以到达某一位置左侧的所有位置。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean canJump2(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return false;
        }

        int maxValue = 0;
        for (int i = 0; i < length; i++) {
            if (i > maxValue) {
                return false;
            }

            maxValue = Math.max(maxValue, i + nums[i]);

            if (maxValue >= length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 回溯算法 - 超时
     */
    private static boolean canJump3(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return false;
        }

        return dfs(nums, 0, length);
    }

    private static boolean dfs(int[] nums, int currentIndex, int length) {
        if (currentIndex >= length - 1) {
            return true;
        }

        boolean valid = false;
        for (int i = nums[currentIndex]; i >= 1; i--) {
            valid |= dfs(nums, currentIndex + i, length);
//            System.out.println("valid: " + valid);
        }

        return valid;
    }

}
