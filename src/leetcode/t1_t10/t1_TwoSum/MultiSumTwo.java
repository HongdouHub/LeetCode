package leetcode.t1_t10.t1_TwoSum;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class MultiSumTwo {

    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(twoSum(new int[] {1,1,1,2,2,3,3}, 4)));
    }

    private static List<List<Integer>> twoSum(int[] nums, int target) {
        return twoSum(nums, 0, target);
    }

    /**
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     */
    static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        int low = start;
        int high = length - 1;

        List<List<Integer>> result = new ArrayList<>();
        while (low < high) {
            int left = nums[low];
            int right = nums[high];
            int sum = left + right;

            if (sum < target) {
                do low++;
                while (low < high && nums[low] == left);
            } else if (sum > target) {
                do high--;
                while (low < high && nums[high] == right);
            } else {
                result.add(Arrays.asList(left, right));

                // 跳过所有重复的元素
                while (low < high && nums[low] == left) low++;
                while (low < high && nums[high] == right) high--;
            }
        }
        return result;
    }
}
