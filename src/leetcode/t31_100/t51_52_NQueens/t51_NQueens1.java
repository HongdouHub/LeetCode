package leetcode.t31_100.t51_52_NQueens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N皇后
 * <p>
 * 将 n 个皇后放置在 n x n 的棋盘山
 */
public class t51_NQueens1 {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Set<Integer> cols = new HashSet<>();
    private static Set<Integer> pies = new HashSet<>();
    private static Set<Integer> nas = new HashSet<>();

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> lists = solveNQueens(n);
        List<List<String>> data = generateResult(lists, n);
        printData(data);
    }

    private static List<List<Integer>> solveNQueens(int n) {
        if (n < 1) return new ArrayList<>();

        solveByDFS(n, 0, new ArrayList<>());
        return result;
    }

    private static void solveByDFS(int n, int row, List<Integer> curState) {
        if (row >= n) {
            result.add(new ArrayList<>(curState));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pies.contains(row + col) || nas.contains(row - col)) {
                // go die
                continue;
            }

            cols.add(col);
            pies.add(row + col);
            nas.add(row - col);
            curState.add(col);

            solveByDFS(n, row + 1, curState);

            cols.remove(col);
            pies.remove(row + col);
            nas.remove(row - col);
            curState.remove(curState.size() - 1);
        }
    }

    private static List<List<String>> generateResult(List<List<Integer>> list, int n) {
        List<String> cache = new ArrayList<>();
        StringBuilder builder;
        for (List<Integer> res : list) {
            for (Integer integer : res) {
                builder = new StringBuilder();
                for (int index = 0; index < n; index++) {
                    builder.append(".");
                }
                builder.setCharAt(integer, 'Q');
                cache.add(builder.toString());
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (int index = 0; index < cache.size(); index = index + n) {

            List<String> temp = new ArrayList<>();
            for (int j = index; j < index + n; j++) {
                temp.add(cache.get(j));
            }
            result.add(temp);
        }
        return result;
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
