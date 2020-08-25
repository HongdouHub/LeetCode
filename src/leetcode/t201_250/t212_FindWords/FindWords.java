package leetcode.t201_250.t212_FindWords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索 II
 */
public class FindWords {

    private static Set<String> result = new HashSet<>();

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

    public static List<String> findWords(char[][] board, String[] words) {
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

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<String>(result);
    }

    private static void dfs(char[][] board, boolean[][] visited, String str, int row, int col, Trie trie) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if (visited[row][col]) return;

        str += board[row][col];
        if (!trie.startWith(str)) return;

        if (trie.search(str)) {
            result.add(str);
        }

        visited[row][col] = true;
        dfs(board, visited, str, row - 1, col, trie);
        dfs(board, visited, str, row + 1, col, trie);
        dfs(board, visited, str, row, col - 1, trie);
        dfs(board, visited, str, row, col + 1, trie);
        visited[row][col] = false;
    }

    private static void printData(List<String> data) {
        for (String s : data) {
            System.out.println(s);
        }
        System.out.println();
    }
}