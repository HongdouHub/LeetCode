package leetcode.t398_Solution;

import java.util.Random;

/**
 * 398. 随机数索引
 *
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。
 * 您可以假设给定的数字一定存在于数组中。
 *
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 */
public class Solution {

    private Random random = new Random();
    private int[] array;

    public Solution(int[] nums) {
        this.array = nums;
    }

    public int pick(int target) {
        int n = 0;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                n++;

                if (random.nextInt(n) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }

}
