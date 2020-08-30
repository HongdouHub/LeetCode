package leetcode.t300_LongestIncreasingSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最长上升子序列
 */
public class LongestIncreasingSequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS1(new int[] {10, 9, 2, 5, 3, 7, 101, 18, 20}));
        System.out.println(lengthOfLIS1(new int[] {1, 3, 6, 7, 9, 4, 10, 5, 6}));

        System.out.println(lengthOfLIS1(new int[] {10, 9, 2, 5, 3, 7, 101, 18, 20}));
        System.out.println(lengthOfLIS2(new int[] {10, 9, 2, 5, 3, 7, 101, 18, 20}));


        System.out.println(lengthOfLIS1(new int[] {3, 1000, 2000, 4}));
        System.out.println(lengthOfLIS2(new int[] {3, 1000, 2000, 4}));
    }

    /**
     * 动态规划 - O(N^2)
     * dynamic programmer
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    private static int lengthOfLIS1(int[] raw) {
        int length;
        if (raw == null || (length = raw.length) == 0) {
            return 0;
        }

        // 1.状态定义，dp[i] 表示 i 个长度的字符中最长子序列的长度
        int[] dp = new int[length];

        // 2.初始化状态
        Arrays.fill(dp, 1);

        // 3.思考状态转移方程
        int maxValue = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (raw[j] < raw[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }

    /**
     * 二分查找
     *
     * 时间复杂度：O(N·logN)
     * 空间复杂度：O(n)
     */
    private static int lengthOfLIS2(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }

        int[] tails = new int[length];
        int left, right, middle;
        int result = 0;

        for(int num : nums) {
            left = 0;
            right = result;

            while(left < right) {
                middle = (left + right) >> 1;

                if (tails[middle] < num) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            tails[left] = num;

            if(result == right) {
                result++;
            }
        }
        return result;
    }

    /**
     * 二分查找
     *
     * 时间复杂度：O(N·logN)
     * 空间复杂度：O(n)
     */
    private static int lengthOfLIS3(int[] raw) {
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
//        int left = 0;
//        int right = result.size() - 1;
//        int middle;
//
//        while (left < right) {
//            middle = (left + right) >> 1;
//
//        }

        int maxValue = 0;
        int index = 0;

        for (int i = 0; i < result.size(); i++) {

            if (result.get(i) < num) {
                if (maxValue <= result.get(i)) {
                    maxValue = result.get(i);
                    index = i;
                }
            }
        }

        return index;
    }

}
