package leetcode.t31_100.t36_37_Sudoku;

/**
 * 数独游戏
 * <p>
 * 1. 暴力法
 */
public class Sudoku {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'.', '4', '6', '9', '.', '3', '.', '.', '.'},
                new char[]{'.', '.', '3', '.', '5', '8', '.', '6', '.'},
                new char[]{'9', '.', '.', '.', '.', '2', '.', '.', '3'},
                new char[]{'.', '.', '5', '.', '.', '6', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '1', '.'},
                new char[]{'.', '1', '.', '7', '.', '.', '2', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '5', '.'},
                new char[]{'.', '.', '1', '3', '.', '.', '.', '.', '7'},
                new char[]{'.', '.', '.', '.', '.', '.', '1', '.', '4'}
        };

//        char[][] board = new char[][]{
//                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };

//        char[][] board = new char[][]{
//                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '8'},
//                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                new char[]{'.', '.', '.', '.', '1', '9', '.', '.', '5'},
//                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };

        print(board);

        boolean success = solveSudoku(board);
        if (success) {
            print(board);
        } else {
            System.out.println("失败");
        }

    }

    private static boolean solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        return solveByRecursion(board);
    }

    private static boolean solveByRecursion(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solveByRecursion(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }

            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    private static void print(char[][] data) {
        for (char[] aBoard : data) {
            for (char anABoard : aBoard) {
                System.out.print(anABoard + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
