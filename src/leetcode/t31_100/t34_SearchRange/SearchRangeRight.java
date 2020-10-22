package leetcode.t31_100.t34_SearchRange;

public class SearchRangeRight {

    /**
     * 寻找右侧边界的二分搜索
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
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return new int[] {-1, -1};
        }

        left = right;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        return new int[] {left + 1, right};
    }

    /**
     * 寻找右侧边界的二分搜索
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
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        if (right == 0 || nums[right - 1] != target) {
            return new int[] {-1, -1};
        }

        left = right - 1;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        return new int[] {left + 1, right - 1};
    }

}
