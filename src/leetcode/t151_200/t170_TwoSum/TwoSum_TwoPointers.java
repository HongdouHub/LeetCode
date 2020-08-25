package leetcode.t151_200.t170_TwoSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 双指针法
 *
 * 时间复杂度：
 *      - add(number)： O(1)
 *      - find(value)： O(N⋅log(N))
 *
 * 空间复杂度：
 *      - O(N)
 */
public class TwoSum_TwoPointers implements TwoSum {

    private List<Integer> nums;
    private volatile boolean isSorted;

    public TwoSum_TwoPointers() {
        this.nums = new ArrayList<>();
        this.isSorted = false;
    }

    @Override
    public void add(int number) {
        this.nums.add(number);
        this.isSorted = false;
    }

    @Override
    public boolean find(int value) {
        if (!isSorted) {
            Collections.sort(nums);
        }

        int length;
        if (nums == null || (length = nums.size()) == 0) {
            return false;
        }

        int low = 0;
        int high = length - 1;

        while (low < high) {

            int sum = nums.get(low) + nums.get(high);

            if (sum == value) {
                return true;
            } else if (sum < value) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }
}
