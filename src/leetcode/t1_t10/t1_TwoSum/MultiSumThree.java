package leetcode.t1_t10.t1_TwoSum;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class MultiSumThree {

    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(threeSum(new int[] {1,1,1,2,3}, 6)));
    }

    private static List<List<Integer>> threeSum(int[] nums, int target) {
        return threeSum(nums, 0, target);
    }

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    static List<List<Integer>> threeSum(int[] nums, int start, int target) {

        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            List<List<Integer>> twoSumList = MultiSumTwo.twoSum(nums, i + 1, target - nums[i]);

            for (List<Integer> twoSum : twoSumList) {
                result.add(Arrays.asList(nums[i], twoSum.get(0), twoSum.get(1)));
            }

            // 跳过所有重复的元素
            while (i < length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return result;
    }

}
