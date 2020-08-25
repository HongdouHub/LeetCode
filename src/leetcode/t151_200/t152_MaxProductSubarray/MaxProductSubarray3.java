package leetcode.t151_200.t152_MaxProductSubarray;

/**
 * 乘积最大子序列
 *
 * 动态规划（用变量存储）（时间复杂度：O(n)）
 */
public class MaxProductSubarray3 {

    public static void main(String[] args) {
        int[] raw = new int[]{-1, -2, -9, -6};
        System.out.println(getMaxValue(raw));
    }

    private static int getMaxValue(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int curMax = nums[0];
        int curMin = nums[0];
        int result = nums[0];

        int num;
        int temp;
        for (int i = 1; i < nums.length; i++) {
            num = nums[i];

            curMax = curMax * num;
            curMin = curMin * num;

            temp = curMax;
            curMax = max(curMax, curMin, num);
            curMin = min(temp, curMin, num);

            result = Math.max(result, curMax);
        }
        return result;
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
