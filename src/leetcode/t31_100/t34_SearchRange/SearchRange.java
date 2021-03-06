package leetcode.t31_100.t34_SearchRange;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
@SuppressWarnings("all")
public class SearchRange {

    /**
     * 暴力左右指针两边夹
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int[] searchRange(int[] nums, int target) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new int[] {-1, -1};
        }

        int left = 0;
        int right = length - 1;

        while (left < right && (nums[left] != target ||
                nums[right] != target)) {

            if (nums[left] != target) {
                left++;
            }

            if (nums[right] != target) {
                right--;
            }
        }

        if (nums[left] != target || nums[right] != target) {
            return new int[] {-1, -1};
        } else {
            return new int[] {left, right};
        }
    }
}
