package leetcode.t31_100.t56_Merge;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 */
public class Merge {

    public static void main(String[] args) {
        test(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        test(new int[][]{{1, 4}, {4, 5}});
    }

    private static void test(int[][] ints) {
        System.out.println(GsonUtil.array2Json(Arrays.asList(merge(ints))));
    }

    /**
     * 排序 + 双指针
     *
     * 时间复杂度：O(n · log n)
     * 空间复杂度：O(log n)
     */
    private static int[][] merge(int[][] intervals) {
        int length;
        if (intervals == null || (length = intervals.length) == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 以 start 升序排序， 如果 start 相等，则以 end 升序排序
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        List<int[]> temp = new ArrayList<>();
        int start = intervals[0][0];
        int maxEnd = intervals[0][1];

        for (int i = 0; i < length; i++) {
            if (maxEnd < intervals[i][0]) {
                temp.add(new int[] {start, maxEnd});
                start = intervals[i][0];
            }
            maxEnd = Math.max(maxEnd, intervals[i][1]);

            if (i == length - 1) {
                temp.add(new int[] {start, maxEnd});
            }
        }

        int[][] result = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            result[i][0] = temp.get(i)[0];
            result[i][1] = temp.get(i)[1];
        }

        return result;
    }
}
