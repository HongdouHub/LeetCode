package leetcode.t384_Solution;

import java.util.List;
import java.util.Random;

/**
 * 暴力解法
 *
 * 时间复杂度： O(n^2)
 * 空间复杂度： O(n)
 */
public class Solution1 implements ISolution {

    private int[] original;
    private int[] array;
    private Random random = new Random();

    public Solution1(int[] nums) {
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
        List<Integer> asList = Utils.asList(array);

        for (int i = 0; i < array.length; i++) {
            int removeIndex = random.nextInt(asList.size());
            array[i] = asList.remove(removeIndex);
        }

        return array;
    }
}
