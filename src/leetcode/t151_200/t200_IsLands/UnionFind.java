package leetcode.t151_200.t200_IsLands;

import leetcode.preparation.array.PrepareArray;
import leetcode.preparation.unionfind.IUnionFind;
import leetcode.preparation.unionfind.UnionFind4;

import java.util.HashSet;
import java.util.Set;

/**
 * 并查集
 */
public class UnionFind implements INumIslands {

    @Override
    public int numIslands(char[][] grid) {
        int len1;
        int len2;
        if (grid == null || (len1 = grid.length) == 0 ||
                (len2 = grid[0].length) == 0) {
            return 0;
        }

//        PrepareArray.print(grid);

        // 将二维坐标映射到一维的常用技巧：
        // 二维坐标 (x,y) 可以转换成 x * n + y 这个数（m 是棋盘的行数，n 是棋盘的列数）

        // 给 dummy 留一个额外位置
        IUnionFind unionFind = new UnionFind4(len1 * len2 + 1);
        int dummy = len1 * len2;

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int currentIndex = i * len2 + j;
                if (grid[i][j] == '1') { // 陆地
                    // 将 currentIndex 连接到 (x, y)下，那么相连的陆地最终是同一个值
                    union(unionFind, grid, currentIndex, i - 1, j, len1, len2);
                    union(unionFind, grid, currentIndex, i + 1, j, len1, len2);
                    union(unionFind, grid, currentIndex, i, j - 1, len1, len2);
                    union(unionFind, grid, currentIndex, i, j + 1, len1, len2);
                } else { // 水
                    // 将 currentIndex 连接到 dummy
                    unionFind.union(currentIndex, dummy);
                }
            }
        }

//        unionFind.print();

        int count = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int root = unionFind.findRoot(i * len2 + j);
                if (root != dummy && !set.contains(root)) {
                    set.add(root);
                    count++;
                }
            }
        }

        // 去除dummy水的集合
        return count;
    }

    private void union(IUnionFind unionFind, char[][] grid, int currentIndex,
                       int x, int y, int len1, int len2) {

        if (x < 0 || x >= len1) {
            return;
        }

        if (y < 0 || y >= len2) {
            return;
        }

        // 忽略水
        if (grid[x][y] == '1') {
            unionFind.union(currentIndex, x * len2 + y);
        }
    }
}
