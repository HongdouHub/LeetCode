package leetcode.t151_200.t169_Majority;

import java.util.Arrays;

/**
 * 169. 多数元素
 * 求众数 : count(x) > n/2
 *
 * 方法一： 暴力求解： Loop : Loop count(x) -- O(N^2)
 * 方法二： Map<x, count(x)> -- O(N)
 * 方法三： 先sorted ，再看重复的数据是否大于 n/2，如果有就是解
 * 方法四： 分治的做法，左半部分找最多的数，右边也找最多的数：
 *               要多加判断，不然有bug
 *          a. left == right -> left
 *          b. left > right  -> left
 *          c. left < right  -> right
 */
public class Majority {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,2,3}));         // 3
        System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2})); // 2
    }

    private static int majorityElement(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int result = nums[0];
        int preCount = 0;
        int curCount = 0;

        for (int i = 0; i < length; i++) {
            if (result != nums[i]) {
                curCount++;
                if (preCount < curCount) {
                    preCount = curCount;
                    result = nums[i];
                }
            } else {
                preCount++;
            }
            if (preCount > length / 2) {
                return result;
            }
        }

        return result;
    }

}
