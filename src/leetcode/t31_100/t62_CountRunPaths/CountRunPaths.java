package leetcode.t31_100.t62_CountRunPaths;

/**
 * 走格子，只能向右或向下走
 * <p>
 * 有多少中走法
 * 时间复杂度： O(m*n)
 */
public class CountRunPaths {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', 'B', '.', '.', '.', 'B', '.'},
                new char[]{'.', '.', '.', '.', 'B', '.', '.', '.'},
                new char[]{'B', '.', 'B', '.', '.', 'B', '.', '.'},
                new char[]{'.', '.', 'B', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', 'B', 'B', '.', 'B', '.'},
                new char[]{'.', 'B', '.', '.', '.', 'B', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        boolean[][] translate = translate(board);
        System.out.println(countPaths(translate));
    }

    private static int countPaths(boolean[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] data = new int[m][n];
        for (int i = 0; i < m; i++) data[i][0] = 1;
        for (int j = 0; j < n; j++) data[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j]) { // 是空地，可达
                    data[i][j] = data[i - 1][j] + data[i][j - 1];
                } else { // 是石头，不可达
                    data[i][j] = 0;
                }
            }
        }
        return data[m - 1][n - 1];
    }

    private static boolean[][] translate(char[][] raw) {
        int m = raw.length;
        int n = raw[0].length;

        // 旋转前的数组
        boolean[][] temp = new boolean[m][n];
        // 旋转后的数组
        boolean[][] board = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = ('B' != raw[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = temp[m - 1 - i][n - 1 - j];
            }
        }
        return board;
    }
}
