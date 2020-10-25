package leetcode.t201_250.t212_FindWords;

import leetcode.preparation.trie.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，
 * 找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *      输入:
 *          words = ["oath","pea","eat","rain"] and board =
 *          [
 *            ['o','a','a','n'],
 *            ['e','t','a','e'],
 *            ['i','h','k','r'],
 *            ['i','f','l','v']
 *          ]
 *      输出: ["eat","oath"]
 */
public class FindWords {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'o', 'a', 'a', 'n'},
                new char[]{'e', 't', 'a', 'e'},
                new char[]{'i', 'h', 'k', 'r'},
                new char[]{'i', 'f', 'l', 'v'},
        };

        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        List<String> data = findWords(board, words);
        printData(data);
    }

    private static List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null) {
            return new ArrayList<>();
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> result = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, trie, i, j, visited, "", result);
            }
        }
        return new ArrayList<String>(result);
    }

    private static void dfs(char[][] board, Trie trie, int row, int col,
                            boolean[][] visited, String path, Set<String> result) {

        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length) {
            return;
        }
        if (visited[row][col]) {
            return;
        }

        path += board[row][col];
        if (!trie.startsWith(path)) {
            return;
        }

        if (trie.search(path)) {
            result.add(path);
        }

        visited[row][col] = true;
        dfs(board, trie, row - 1, col, visited, path, result);
        dfs(board, trie, row + 1, col, visited, path, result);
        dfs(board, trie, row, col - 1, visited, path, result);
        dfs(board, trie, row, col + 1, visited, path, result);
        visited[row][col] = false;
    }

    private static void printData(List<String> data) {
        for (String s : data) {
            System.out.println(s);
        }
        System.out.println();
    }
}