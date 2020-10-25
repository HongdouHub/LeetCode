package leetcode.t451_650.t496_NextGreaterElement;

import utils.GsonUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static utils.ConsoleUtils.println;

/**
 * 496. 下一个更大元素 I（不可重复）
 *
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
 * 如果不存在，对应位置输出 -1
 *
 * 示例 1:
 *      输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 *      输出: [-1,3,-1]
 *      解释:
 *          对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *          对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *          对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 */
@SuppressWarnings("all")
public class NextGreaterElement {

    public static void main(String[] args) {
        test(new int[] {4,1,2}, new int[] {1,3,4,2});
        test(new int[] {2,4}, new int[] {1,2,3,4});
        test(new int[] {1,3,5,2,4}, new int[] {5,4,3,2,1});
        test(new int[] {3,1,5,7,9,2,6}, new int[] {1,2,3,5,6,7,9,11}); // 5,2,6,9,11,3,7
    }

    private static void test(int[] nums1, int[] nums2) {
        println(GsonUtil.array2Json(Arrays.asList(nextGreaterElement1(nums1, nums2))));
        println(GsonUtil.array2Json(Arrays.asList(nextGreaterElement2(nums1, nums2))));
        System.out.println("-----------\n");
    }

    /**
     * 双指针
     *
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     */
    private static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int len1, len2;
        if (nums1 == null || (len1 = nums1.length) == 0 ||
                nums2 == null || (len2 = nums2.length) == 0) {
            return new int[0];
        }

        Map<Integer, Integer> hashMap = new HashMap<>();
        int left;
        int right;

        for (left = 0; left < len2; left++) {
            right = left + 1;
            // 尾指针，默认-1
            if (left == len2 - 1) {
                hashMap.put(nums2[left], -1);
            } else {

                while (right < len2) {

                    if (nums2[left] < nums2[right]) {
                        hashMap.put(nums2[left], nums2[right]);
                        break;
                    }
                    right++;
                }

                // 未匹配上
                if (right == len2) {
                    hashMap.put(nums2[left], -1);
                }
            }
        }

        int[] result = new int[len1];
        for (int i = 0; i < len1; i++) {
            result[i] = hashMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    /**
     * 单调栈
     *
     * 时间复杂度：O(N + M)
     * 空间复杂度：O(N)
     */
    private static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int len1;
        if (nums1 == null || (len1 = nums1.length) == 0 ||
                nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> hashMap = nextGreaterElementHelper(nums2);

        int[] result = new int[len1];
        for (int i = 0; i < len1; i++) {
            result[i] = hashMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    private static Map<Integer, Integer> nextGreaterElementHelper(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int len = nums.length;
        Stack<Integer> stack = new Stack<>(); // 存放高个元素的栈

        for (int i = len - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                // 矮个起开，反正也被挡住了
                stack.pop();
            }

            // 当前元素身后的第一个高个
            hashMap.put(nums[i], stack.isEmpty() ? -1 : stack.peek());

            // 入栈，接受之后的身高判定
            stack.push(nums[i]);
        }

        return hashMap;
    }
}
