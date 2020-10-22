package leetcode.t1_t10.t1_TwoSum;

import utils.GsonUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 2, 11, 15};
        int target = 4;
//        int[] nums = new int[] {2, 7, 11, 15};
//        int target = 9;

        int[] result = twoSum(nums, target);
        int[] resultValue = new int[result.length];

        for (int i = 0; i < nums.length; i++) {
            if (result[0] == i) {
                resultValue[0] = nums[i];
                continue;
            }
            if (result[1] == i) {
                resultValue[1] = nums[i];
            }
        }

        System.out.println(GsonUtil.array2Json(Arrays.asList(result)));
        System.out.println(GsonUtil.array2Json(Arrays.asList(resultValue)));
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

}
