package leetcode.t31_100.t47_PermuteUnique;

import utils.GsonUtil;

/**
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出: [
 *        [1,1,2],
 *        [1,2,1],
 *        [2,1,1]
 *      ]
 */
public class Solution {

    public static void main(String[] args) {
        permuteUnique1(new int[] {1, 2, 2});
        permuteUnique1(new int[] {2, 2, 1, 1});

        permuteUnique2(new int[] {1, 2, 2});
        permuteUnique2(new int[] {2, 2, 1, 1});
    }

    private static void permuteUnique1(int[] nums) {
        IPermuteUnique unique1 = new PermuteUnique1();

        System.out.println(GsonUtil.array2Json(unique1.permuteUnique(nums)));
    }

    private static void permuteUnique2(int[] nums) {
        IPermuteUnique unique2 = new PermuteUnique2();

        System.out.println(GsonUtil.array2Json(unique2.permuteUnique(nums)));
    }
}
