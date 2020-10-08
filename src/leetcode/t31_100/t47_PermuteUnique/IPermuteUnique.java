package leetcode.t31_100.t47_PermuteUnique;

import java.util.List;

public interface IPermuteUnique {

    /**
     * 回溯算法
     *
     * 时间复杂度：O(N × N!)
     * 空间复杂度：O(N × N!)
     */
    List<List<Integer>> permuteUnique(int[] nums);
}
