package leetcode.t1_t10.t1_TwoSum;

import utils.GsonUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums;

        nums = new int[] {2, 2, 11, 15};
        print(nums, twoSum(nums, 4));

        nums = new int[] {2, 7, 11, 15};
        print(nums, twoSum(nums, 9));
    }

    /**
     * 暴力求解
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */

    /**
     * 哈希表
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int[] twoSum(int[] nums, int target) {
        int size;
        if (nums == null || (size = nums.length) == 0)
            throw new IllegalArgumentException("No two sum solution");

        Map<Integer, Integer> recordMap = new HashMap<>();
        int anotherAddend;
        for (int i = 0; i < size; i++) {
            anotherAddend = target - nums[i];

            if (recordMap.containsKey(anotherAddend)) {
                return new int[] {recordMap.get(anotherAddend), i};
            }
            recordMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static void print(int[] nums, int[] result) {
        System.out.print("序号:" + GsonUtil.array2Json(Arrays.asList(result)));
        System.out.print(" -> ");
        System.out.println("值:" + GsonUtil.array2Json(Arrays.asList(getValue(nums, result))));
        System.out.println("------------------");
    }

    private static int[] getValue(int[] nums, int[] result) {
        int[] value = new int[result.length];
        int i = 0;
        int j = 0;
        for (; i < nums.length && j < result.length; i++) {
            if (result[j] == i) {
                value[j++] = nums[i];
            }
        }
        return value;
    }
}
