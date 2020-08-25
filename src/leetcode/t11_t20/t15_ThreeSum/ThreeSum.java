package leetcode.t11_t20.t15_ThreeSum;

import utils.GsonUtil;

import java.util.*;

/**
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {
//        int[] nums = new int[] {2, 7, 11, 15};
//        int target = 20;

//        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[] {0, 0, 0};
        int[] nums = TestData.TEST_DATA;
        int target = 0;

        List<List<Integer>> result = threeSum2(nums, target);
        System.out.println(GsonUtil.array2Json(result));
    }

    /**
     * HashMap登记式
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * [[2,11,7],[7,2,11],[7,11,2],[11,2,7],[11,7,2]] - 未做去重，答案不对
     */
    private static List<List<Integer>> threeSum1(int[] nums, int target) {
        int size;
        if (nums == null || (size = nums.length) < 3)
            throw new IllegalArgumentException("No two sum solution");

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> recordMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int thirdAddend = target - nums[i] - nums[j];

                if (recordMap.containsKey(thirdAddend)) {
                    result.add(Arrays.asList(nums[i], nums[j], thirdAddend));
                }
                recordMap.put(nums[j], j);
            }
        }

        if (!result.isEmpty()) {
            return result;
        } else {
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    /**
     * 双指针往回缩
     *
     * 时间复杂度：O(n2)，
     *     数组排序 O(N log N)，遍历数组 O(n)，双指针遍历 O(n)，
     *     总体 O(N log N) + O(n) ∗ O(n) -> O(n2)
     * 空间复杂度：O(1)
     */
    private static List<List<Integer>> threeSum2(int[] nums, int target) {
        int length;
        if (nums == null || (length = nums.length) < 3) {
            return new ArrayList<>();
        }

        // 快排：升序
        nums = quickSort(nums);
//        Arrays.sort(nums);

        if (nums[0] > target || nums[length - 1] < target) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

//        for (int i = 0; i < length - 2;) {
//
//            int first = i + 1;
//            int last = length - 1;
//
//            do {
//                // 两人选相遇，或者三人同符号，则退出
//                if (first >= last || ((long) nums[i] * (long) nums[last] > 0)) {
//                    break;
//                }
//
//                int result = nums[i] + nums[first] + nums[last];
//
//                // 如果可以组队
//                if (result == target) {
//                    res.add(Arrays.asList(nums[i], nums[first], nums[last]));
//                }
//
//                // 实力太弱，把菜鸟那边右移一位
//                if (result <= target) {
//                    while (first < last && nums[first] == nums[first + 1]) {
//                        first++;
//                    }
//                } else { // 实力太强，把大神那边右移一位
//                    while (first < last && nums[last] == nums[last - 1]) {
//                        last--;
//                    }
//                }
//
//            } while (first < last);
//
//            while (i < (length - 1) && nums[i] == nums[++i]) {
//            }
//        }

        for (int i = 0; i < length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int first = i + 1;
            int last = length - 1;

            while (first < last) {
                // 两人选相遇，或者三人同符号，则退出
                if ((long) nums[i] * (long) nums[last] > 0) {
                    break;
                }

                int result = nums[i] + nums[first] + nums[last];

                // 如果可以组队
                if (result == target) {
                    res.add(Arrays.asList(nums[i], nums[first], nums[last]));

                    while (first < last && nums[first] == nums[first + 1]) {
                        first++;
                    }

                    while (first < last && nums[last] == nums[last - 1]) {
                        last--;
                    }
                }

                // 实力太弱，把菜鸟那边右移一位
                if (result < target) {
                    first++;
                } else { // 实力太强，把大神那边右移一位
                    last--;
                }
            }
        }
        return res;
    }

    private static int[] quickSort(int[] input) {
        int length;
        if (input == null || (length = input.length) == 0) {
            return new int[0];
        }
        return quickSort(input, 0, length - 1);
    }

    private static int[] quickSort(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {

            while ((i < j) && input[j] > pivot) {
                j--;
            }

            while ((i < j) && input[i] < pivot) {
                i++;
            }

            if ((i < j) && input[i] == input[j]) {
                i++;
            } else if (i != j) {
                swap(input, i, j);
            }
        }

        if (i - 1 > start) {
            quickSort(input, start, i - 1);
        }

        if (j + 1 < end) {
            quickSort(input, j + 1, end);
        }
        return input;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
