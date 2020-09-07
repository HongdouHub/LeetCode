package leetcode.t31_100.t42_Trap;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Trap {

    public static void main(String[] args) {
        System.out.println(trap1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * 暴力解法
     *
     * 时间复杂度：O(n²）
     * 空间复杂度：O(1）
     */
    private static int trap1(int[] height) {
        int length;
        if (height == null || (length = height.length) == 0) {
            return 0;
        }

        int sum = 0;
        int left;
        int right;
        int min;

        // 最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < length - 1; i++) {
            left = 0;
            right = 0;
            // 找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > left) {
                    left = height[j];
                }
            }

            // 找出右边最高
            for (int j = i + 1; j < length; j++) {
                if (height[j] > right) {
                    right = height[j];
                }
            }

            // 找出两端较小的
            min = Math.min(left, right);

            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }

        return sum;
    }

    /**
     * 暴力解法 - 重复计算优化
     *
     * 时间复杂度：O(n）
     * 空间复杂度：O(n）
     */
    private static int trap2(int[] height) {
        int length;
        if (height == null || (length = height.length) == 0) {
            return 0;
        }

        int sum = 0;

        int[] left = new int[length];
        int[] right = new int[length];

        for (int i = 1; i < length - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        for (int i = 1; i < length - 1; i++) {
            int min = Math.min(left[i], right[i]);

            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }

        return sum;
    }

}
