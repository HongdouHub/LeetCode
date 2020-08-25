package leetcode.t11_t20.t18_FourSum;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 */
public class FourSum {

    public static void main(String[] args) {
//        System.out.println(GsonUtil.array2Json(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)));
        System.out.println(GsonUtil.array2Json(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11)));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        int length;
        if(nums==null || (length = nums.length) < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = length - 1;

                while (left < right) {

                    int result = nums[i] + nums[j] + nums[left] + nums[right];

                    if (result < target) {
                        left++;
                    } else if (result > target) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while ((left < right) && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while ((left < right) && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    }
                }

            }
        }

        return res;
    }

}
