package leetcode.t351_400.t384_Solution;

import java.util.Random;

/**
 *  Fisher-Yates 洗牌算法
 *
 * 时间复杂度： O(n)
 * 空间复杂度： O(n)
 */
public class Solution2 implements ISolution {

    private int[] original;
    private int[] array;
    private Random random = new Random();

    public Solution2(int[] nums) {
        this.original = nums.clone();
        this.array = nums;
    }

    @Override
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    @Override
    public int[] shuffle() {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            swapAt(i, randRange(i, length));
        }

        return array;
    }

    private int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
