package leetcode.t151_200.t167_TwoSum;

import utils.GsonUtil;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *     返回的下标值（index1 和 index2）不是从零开始的。
 *     你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums;

        nums = new int[] {2, 2, 11, 15};
        print(nums, twoSum1(nums, 4));

        nums = new int[] {2, 2, 11, 15};
        print(nums, twoSum2(nums, 4));

        nums = new int[] {2, 7, 11, 15};
        print(nums, twoSum1(nums, 9));

        nums = new int[] {2, 7, 11, 15};
        print(nums, twoSum2(nums, 9));
    }

    /**
     * 二分查找
     *
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     */
    private static int[] twoSum1(int[] numbers, int target) {
        int length;
        if (numbers == null || (length = numbers.length) == 0) {
            return new int[]{-1, -1};
        }

        for (int i = 0; i < length; i++) {
            int low = i + 1;
            int high = length - 1;

            int minus = target - numbers[i];
            while (low <= high) {

                int middle = (low + high) >> 1;

                if (numbers[middle] == minus) {

                    return new int[] {i, middle};
                } else if (numbers[middle] > minus) {

                    high = middle - 1;
                } else {

                    low = middle + 1;
                }
            }
        }

        return new int[] {-1, -1};
    }

    /**
     * 双指针
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] twoSum2(int[] numbers, int target) {
        int length;
        if (numbers == null || (length = numbers.length) == 0) {
            return new int[]{-1, -1};
        }

        int low = 0;
        int high = length - 1;

        while (low < high) {
            int sum = numbers[low] + numbers[high];

            if (sum == target) {
                return new int[] {low, high};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }

    private static void print(int[] nums, int[] result) {
        System.out.print("序号:" + GsonUtil.array2Json(Arrays.asList(result)));
        System.out.print(" -> ");
        System.out.println("值:" + GsonUtil.array2Json(Arrays.asList(getResultValue(nums, result))));
        System.out.println("------------------");
    }

    private static int[] getResultValue(int[] nums, int[] result) {
        int[] resultValue = new int[result.length];

        for (int i = 0, j = 0; i < nums.length && j < result.length; i++) {
            if (result[j] == i) {
                resultValue[j++] = nums[i];
            }
        }
        return resultValue;
    }
}
