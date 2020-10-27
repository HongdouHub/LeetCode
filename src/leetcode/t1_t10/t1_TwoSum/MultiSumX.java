package leetcode.t1_t10.t1_TwoSum;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class MultiSumX {

    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(xSum(new int[] {1,1,1,2,3}, 4, 6)));
    }

    private static List<List<Integer>> xSum(int[] nums, int x, int target) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        return sum(nums, x, 0, length, target);
    }

    private static List<List<Integer>> sum(int[] nums, int x, int start, int end, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (x < 2 || end < x) {
            return result;
        }

        if (x == 2) {
            int low = start;
            int high = end - 1;

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
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    result.add(list);

                    // 跳过所有重复的元素
                    while (low < high && nums[low] == left) low++;
                    while (low < high && nums[high] == right) high--;
                }
            }
        } else {
            // n > 2 时，递归计算 (n-1)Sum 的结果

            for (int i = start; i < end; i++) {
                List<List<Integer>> temp = sum(nums, x - 1, i + 1, end, target - nums[i]);

                for (List<Integer> list : temp) {
                    list.add(nums[i]);
                    result.add(list);
                }

                // 跳过所有重复的元素
                while (i < end - 1 && nums[i] == nums[i + 1]) i++;
            }
        }

        return result;
    }

}
