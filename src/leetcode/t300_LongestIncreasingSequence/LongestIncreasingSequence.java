package leetcode.t300_LongestIncreasingSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长上升子序列
 */
public class LongestIncreasingSequence {

    public static void main(String[] args) {
        int[] raw = new int[] {10, 9, 2, 5, 3, 7, 101, 18, 20};

        System.out.println(solveByDynamicProgramming(raw));
        System.out.println(solveByLIS(raw));
    }

    /**
     * 动态规划 - O(N^2)
     */
    private static int solveByDynamicProgramming(int[] raw) {
        int size;
        if (raw == null || (size = raw.length) == 0) return 0;

        // 最长子序列的长度
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) dp[i] = 1;

        int maxValue = 1;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (raw[j] < raw[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }

    /**
     * 二分查找 - O(N·logN)
     */
    private static int solveByLIS(int[] raw) {
        int size;
        if (raw == null || (size = raw.length) == 0) return 0;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int index = binSearch(result, raw[i]);

            if (index == result.size()) {
                result.add(raw[i]);
            } else {
                result.set(index, raw[i]);
            }
        }
        return result.size();
    }

    /**
     * 二分查找，找到比 num 小的最大的数的下标 - O(logN)
     */
    private static int binSearch(List<Integer> result, int num) {
        return 0;
    }

}
