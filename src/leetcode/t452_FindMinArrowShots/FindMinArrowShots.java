package leetcode.t452_FindMinArrowShots;

import utils.GsonUtil;

import java.util.Arrays;
import java.util.Comparator;

import static utils.ConsoleUtils.println;

/**
 * 452. 用最少数量的箭引爆气球
 * <p>
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。
 * 开始坐标总是小于结束坐标。平面内最多存在104个气球。
 * <p>
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。
 * 在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。
 * 可以射出的弓箭的数量没有限制。
 * 弓箭一旦被射出之后，可以无限地前进。
 * 我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * Example:
 * 输入: [[10,16], [2,8], [1,6], [7,12]]
 * 输出:  2
 * 解释:  对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 */
public class FindMinArrowShots {

    public static void main(String[] args) {
        println(findMinArrowShots1(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        println(findMinArrowShots1(new int[][] {
                {3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10},
                {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}}));
        println(findMinArrowShots1(new int[][] {
                {9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}}));
    }

    /**
     * 贪心算法
     * <p>
     * 时间复杂度：O(N logN)
     * 空间复杂度：O(1)
     */
    private static int findMinArrowShots1(int[][] points) {
        int length;
        if (points == null || (length = points.length) == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 以end升序排序（必须）
                return o1[1] - o2[1];
            }
        });

        System.out.println(GsonUtil.array2Json(Arrays.asList(points)));

        int count = 1;
        int end = points[0][1]; // 为第一个气球结束的坐标
        for (int i = 0; i < length; i++) {
            if (end < points[i][0]) {
                count++;
                end = points[i][1];
            }
        }

        return count;
    }
}
