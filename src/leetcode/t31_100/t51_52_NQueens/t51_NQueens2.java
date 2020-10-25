package leetcode.t31_100.t51_52_NQueens;

import java.util.*;

/**
 * N皇后
 * <p>
 * 将 n 个皇后放置在 n x n 的棋盘山
 */
public class t51_NQueens2 {

    public static void main(String[] args) {
        printData(solveNQueens(1));
        printData(solveNQueens(4));
    }

    /**
     * 回溯算法 + 深度优先遍历
     *
     * 时间复杂度：O(N!)，其中 N 是皇后数量
     * 空间复杂度：O(N)
     */
    private static List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> pies = new HashSet<>();
        Set<Integer> nas = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(n, 0, cols, pies, nas, path, result);
        return result;
    }

    private static void dfs(int n, int currentRow, Set<Integer> cols,
                            Set<Integer> pies, Set<Integer> nas,
                            List<String> path, List<List<String>> result) {

        if (n <= currentRow) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 遍历列
        for (int i = 0; i < n; i++) {
            // 剪枝
            if (cols.contains(i) || pies.contains(currentRow + i) ||
                    nas.contains(currentRow - i)) {
                continue;
            }

            cols.add(i);
            pies.add(currentRow + i);
            nas.add(currentRow - i);

            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            path.add(String.valueOf(charArray));

            dfs(n, currentRow + 1, cols, pies, nas, path, result);

            cols.remove(i);
            pies.remove(currentRow + i);
            nas.remove(currentRow - i);
            path.remove(path.size() - 1);
        }
    }

    private static void printData(List<List<String>> data) {
        for (List<String> list : data) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
