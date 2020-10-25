package leetcode.t101_150.t130_Solve;

import leetcode.preparation.array.PrepareArray;
import leetcode.preparation.unionfind.IUnionFind;
import leetcode.preparation.unionfind.UnionFind4;

/**
 * 130. 被围绕的区域
 * <p>
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * X X X X      X X X X
 * X O O X      X X X X
 * X X O X  ->  X X X X
 * X O X X      X O X X
 */
@SuppressWarnings("all")
public class Solve {

    public static void main(String[] args) {
        System.out.println("----------solve1----------");
        solve1(new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'},
        });

        System.out.println("----------solve2----------");
        solve2(new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'},
        });
    }

    /**
     * 深度优先遍历
     * 与边缘相连的O改为#，再将所有的O改为X，最后把#改为O
     *
     * 时间复杂度： O(n ^ 2)
     * 空间复杂度： O(1)
     */
    private static void solve1(char[][] board) {
        int len1;
        int len2;

        if (board == null || (len1 = board.length) == 0 || (len2 = board[0].length) == 0) {
            return;
        }

        PrepareArray.print(board);

        // 找到与边缘相连的区域，改为 '#'
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                boolean isEdge = (i == 0 || j == 0 || i == len1 - 1 || j == len2 - 1);
                if (board[i][j] == 'O' && isEdge) {
                    dfs(board, i, j);
                }
            }
        }


        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                // 将原来的 'O' 改为 'X'，因为这些已经被 'X'包围
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                // 将与边缘相连的区域，改为 'O'
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
        PrepareArray.print(board);
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                board[i][j] == 'X' || board[i][j] == '#') {
            // board[i][j] == '#' 说明已经搜索过了.
            return;
        }

        board[i][j] = '#';

        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    /**
     * 并查集
     *
     * 将二维坐标映射到一维，将边缘O与dummy相连，
     * 遍历所有坐标，与四周相连一次
     *
     *
     */
    private static void solve2(char[][] board) {
        int len1;
        int len2;

        if (board == null || (len1 = board.length) == 0 || (len2 = board[0].length) == 0) {
            return;
        }

        PrepareArray.print(board);

        // 将二维坐标映射到一维的常用技巧：
        // 二维坐标 (x,y) 可以转换成 x * n + y 这个数（m 是棋盘的行数，n 是棋盘的列数）

        // 给 dummy 留一个额外位置
        IUnionFind uf = new UnionFind4(len1 * len2 + 1);
        int dummy = len1 * len2;

        // 将首列和末列的 O 与 dummy 连通
        for (int i = 0; i < len1; i++) {
            if (board[i][0] == 'O')
                uf.union(i * len2, dummy);
            if (board[i][len2 - 1] == 'O')
                uf.union(i * len2 + len2 - 1, dummy);
        }
        // 将首行和末行的 O 与 dummy 连通
        for (int j = 0; j < len2; j++) {
            if (board[0][j] == 'O')
                uf.union(j, dummy);
            if (board[len1 - 1][j] == 'O')
                uf.union(len2 * (len1 - 1) + j, dummy);
        }

        for (int i = 1; i < len1 - 1; i++) {
            for (int j = 1; j < len2 - 1; j++) {
                if (board[i][j] == '0') {
                    uf.union((i - 1) * len2 + j, i * len2 + j); // 上
                    uf.union((i + 1) * len2 + j, i * len2 + j); // 下
                    uf.union(i * len2 + j - 1, i * len2 + j);   // 左
                    uf.union(i * len2 + j + 1, i * len2 + j);   // 右
                }
            }
        }

        uf.print();

        for (int i = 1; i < len1 - 1; i++) {
            for (int j = 1; j < len2 - 1; j++) {
                if (!uf.connected(dummy, i * len2 + j)) {
                    board[i][j] = 'X';
                }
            }
        }

        PrepareArray.print(board);
    }
}
