package leetcode.t451_650.t503_NextGreaterElements;

import utils.GsonUtil;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II - 循环数组
 * <p>
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
 * 输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 */
public class NextGreaterElements {

    public static void main(String[] args) {
        // [2,-1,2]
//        test(new int[]{1, 2, 1});

        // [120,11,120,120,123,123,-1,100,100,100]
        test(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100});
    }

    private static void test(int[] nums) {
        System.out.println(GsonUtil.array2Json(Arrays.asList(nextGreaterElements(nums))));
    }

    private static int[] nextGreaterElements(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new int[0];
        }

        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % length]) {
                stack.pop();
            }

            if (i < length) {
                result[i] = stack.isEmpty() ? -1 : stack.peek();
            }
//            result[i % length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % length]);
        }
        return result;
    }
}
