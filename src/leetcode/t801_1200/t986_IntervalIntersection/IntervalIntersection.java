package leetcode.t801_1200.t986_IntervalIntersection;

import java.util.Arrays;

import static leetcode.preparation.array.PrepareArray.print;

/**
 * 986. 区间列表的交集
 *
 * 给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 *
 * 返回这两个区间列表的交集。
 *
 * （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，
 * 而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。
 * 例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 */
@SuppressWarnings("all")
public class IntervalIntersection {

    public static void main(String[] args) {
        print(intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
    }

    private static int[][] intervalIntersection(int[][] A, int[][] B) {

        int aLen = A.length;
        int bLen = B.length;

        int aIndex = 0;
        int bIndex = 0;

        int[][] result = new int[aLen + bLen][2];
        int resultIndex = 0;

        int aStart, aEnd;
        int bStart, bEnd;

        while (aIndex < aLen && bIndex < bLen) {
            aStart = A[aIndex][0];
            aEnd = A[aIndex][1];
            bStart = B[bIndex][0];
            bEnd = B[bIndex][1];

            if (aEnd >= bStart) {

                if (bEnd < aStart) {
                    bIndex++;
                    continue;
                }

                if (aEnd < bEnd) {
                    result[resultIndex][0] = Math.max(aStart, bStart);
                    result[resultIndex][1] = aEnd;
                    resultIndex++;
                    aIndex++;
                } else {
                    result[resultIndex][0] = Math.max(aStart, bStart);
                    result[resultIndex][1] = bEnd;
                    resultIndex++;
                    bIndex++;
                }
                continue;
            }

            if (bEnd >= aStart) {

                if (aEnd < bStart) {
                    aIndex++;
                    continue;
                }

                if (bEnd < aEnd) {
                    result[resultIndex][0] = Math.max(aStart, bStart);
                    result[resultIndex][1] = bEnd;
                    resultIndex++;
                    bIndex++;
                } else {
                    result[resultIndex][0] = Math.max(aStart, bStart);
                    result[resultIndex][1] = aEnd;
                    resultIndex++;
                    aIndex++;
                }
                continue;
            }
        }

        result = Arrays.copyOf(result, resultIndex);
        return result;
    }

}
