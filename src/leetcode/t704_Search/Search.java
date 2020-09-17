package leetcode.t704_Search;

/**
 * 704. 二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 */
public class Search {

    public static void main(String[] args) {
        System.out.println(search(new int[] {-1,0,3,5,9,12}, 9));   // 4
        System.out.println(search(new int[] {-1,0,3,5,9,12}, 2));   // -1
    }

    private static int search(int[] nums, int target) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return -1;
        }

        int left = 0;
        int right = length - 1;
        int middle;

        while (left <= right) {
            middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }
        return -1;
    }

}
