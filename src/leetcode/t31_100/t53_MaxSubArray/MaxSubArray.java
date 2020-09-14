package leetcode.t31_100.t53_MaxSubArray;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *      输入: [-2,1,-3,4,-1,2,1,-5,4]
 *      输出: 6
 *      解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
@SuppressWarnings("all")
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); //6
    }

    private static int maxSubArray(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }

        int sum;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                result = Math.max(result, sum);
            }
        }
        return result;
    }

}
