package leetcode.t1_t10.t1_TwoSum;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class MultiSumFour {

    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(fourSum(new int[] {1,1,1,2,3}, 6)));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        return fourSum(nums, 0, target);
    }

    /**
     * 有问题：1 + [1,1,3] 与 3 + [1,1,1] 有重复
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static List<List<Integer>> fourSum(int[] nums, int start, int target) {

        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            List<List<Integer>> threeSumList = MultiSumThree.threeSum(nums, i + 1, target - nums[i]);

            for (List<Integer> threeSum : threeSumList) {
                result.add(Arrays.asList(nums[i], threeSum.get(0), threeSum.get(1), threeSum.get(2)));
            }

            // 跳过所有重复的元素
            while (i < length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return result;
    }

}
