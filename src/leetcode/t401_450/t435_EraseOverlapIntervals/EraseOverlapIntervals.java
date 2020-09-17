package leetcode.t401_450.t435_EraseOverlapIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * <p>
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */
public class EraseOverlapIntervals {

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}})); // 1
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));         // 2
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));                 // 0
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - intervalSchedule(intervals);
    }

    /**
     * 贪心解法
     */
    private static int intervalSchedule(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 以end升序排序
                return o1[1] - o2[1];
            }
        });

        // 至少有一个区间不相交
        int count = 1;

        // 排序后，第一个区间就是 x
        int end = intervals[0][1];

        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= end) {
                // 找到下一个选择的区间了
                count++;
                end = interval[1];
            }
        }

        return count;
    }
}
