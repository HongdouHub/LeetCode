package leetcode.t11_t20.t16_ThreeSumClosest;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] input = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(input, 1));
    }

    private static int threeSumClosest(int[] nums, int target) {
        int length;
        if (nums == null || (length = nums.length) < 3) {
            return 0;
        }

        // 快排：升序
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];

        out:for (int i = 0; i < length - 2; i++) {

            int left = i + 1;
            int right = length - 1;
            int sum;

            while (left < right) {

                sum = nums[i] + nums[left] + nums[left + 1];
                // 三数最小值仍然大于目标值
                if (sum > target) {
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                    break;
                }

                sum = nums[i] + nums[right] + nums[right - 1];
                // 三数最大值仍然小于目标值
                if (sum < target) {
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                    break;
                }

                sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum > target) {
                    right--;

                    while ((left < right) && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < target) {
                    left++;

                    while ((left < right) && nums[left] == nums[left - 1]) {
                        left++;
                    }

                } else {
                    break out;
                }

                while ((i < length - 2) && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return result;
    }

}
