package leetcode.t451_650.t547_FriendCircles;

import leetcode.preparation.unionfind.IUnionFind;
import leetcode.preparation.unionfind.UnionFind4;

/**
 * 547. 朋友圈
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
 * 如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，
 * 否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1：
 *      输入：
 *          [[1,1,0],
 *           [1,1,0],
 *           [0,0,1]]
 *      输出：2
 *      解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
 *      第2个学生自己在一个朋友圈。所以返回 2 。
 *
 * 示例 2：
 *      输入：
 *          [[1,1,0],
 *           [1,1,1],
 *           [0,1,1]]
 *      输出：1
 *      解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，
 *      所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
 */
public class FriendCircles {

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][] {
                new int[] {1, 1, 0},
                new int[] {1, 1, 0},
                new int[] {0, 0, 1}
        }));    // 2

        System.out.println(findCircleNum(new int[][] {
                new int[] {1, 1, 0},
                new int[] {1, 1, 1},
                new int[] {0, 1, 1}
        }));    // 1

        System.out.println(findCircleNum(new int[][] {
                new int[] {1, 0, 0, 1},
                new int[] {0, 1, 1, 0},
                new int[] {0, 1, 1, 1},
                new int[] {1, 0, 1, 1}
        }));    // 1
    }

    /**
     * 并查集
     *
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     */
    private static int findCircleNum(int[][] M) {

        int length;
        if (M == null || (length = M.length) == 0 || M[0].length == 0) {
            return 0;
        }

        // 给 dummy 留一个额外位置
        IUnionFind unionFind = new UnionFind4(length);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

//        unionFind.print();
        return unionFind.count();
    }

}
