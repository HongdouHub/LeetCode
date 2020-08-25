package leetcode.t101_150.t130_Solve;

import leetcode.preparation.array.PrepareArray;

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
        solve(new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'},
        });
    }

    private static void solve(char[][] board) {
        int len1;
        int len2;

        if (board == null || (len1 = board.length) == 0 || (len2 = board[0].length) == 0) {
            return;
        }

        PrepareArray.print(board);

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
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
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

}
