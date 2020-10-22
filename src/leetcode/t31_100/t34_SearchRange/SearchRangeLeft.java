package leetcode.t31_100.t34_SearchRange;

public class SearchRangeLeft {

    /**
     * 寻找左侧边界的二分搜索
     * right = length - 1
     *
     * 时间复杂度： O(logn)
     * 空间复杂度： O(1)
     */
    public static int[] searchRange1(int[] nums, int target) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new int[] {-1, -1};
        }

        int left = 0;
        int right = length - 1;
        int middle;
        while (left <= right) {
            middle = left + ((right - left) >> 1);

            if (nums[middle] == target) {
                right = middle - 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if (left >= length || nums[left] != target) {
            return new int[] {-1, -1};
        }

        right = left;
        while (right < length && nums[right] == target) {
            right++;
        }
        return new int[] {left, right - 1};
    }

    /**
     * 寻找左侧边界的二分搜索
     * right = length
     *
     * 时间复杂度： O(logn)
     * 空间复杂度： O(1)
     */
    public static int[] searchRange2(int[] nums, int target) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new int[] {-1, -1};
        }

        int left = 0;
        int right = length;
        int middle;

        while (left < right) {
            middle = left + ((right - left) >> 1);

            if (nums[middle] == target) {
                right = middle;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        if (left >= length || nums[left] != target) {
            return new int[] {-1, -1};
        }

        right = left;
        while (right < length && nums[right] == target) {
            right++;
        }
        return new int[] {left, right - 1};
    }

}
