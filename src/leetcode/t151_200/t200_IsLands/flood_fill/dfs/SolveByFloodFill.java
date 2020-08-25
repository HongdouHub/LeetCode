package leetcode.t151_200.t200_IsLands.flood_fill.dfs;

import leetcode.t151_200.t200_IsLands.IsLands;
import leetcode.t151_200.t200_IsLands.Point;

import java.util.HashSet;
import java.util.Set;

/**
 * 染色法
 */
public class SolveByFloodFill extends IsLands {
    private static int[] dx = new int[] {-1, 1, 0, 0};
    private static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] landData = getLandData();
        System.out.println(solveByFloodFillDFS2(landData));

        System.out.println(solveByFloodFillDFS1(landData));
    }

    // 深度优先
    private static int solveByFloodFillDFS1(int[][] grid) {
        int maxX, maxY;
        if (grid == null || (maxX = (grid.length)) == 0 ||
                (maxY = (grid[0].length)) == 0) return 0;

        int numIslands = 0;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (grid[i][j] == 1) {
                    numIslands += dfs(grid, i, j, maxX, maxY);
                }
            }
        }
        return numIslands;
    }

    private static int dfs(int[][] grid, int row, int col, int maxX, int maxY) {
        if (row < 0 || row >= maxX || col < 0 || col >= maxY || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        dfs(grid, row - 1, col, maxX, maxY);
        dfs(grid, row + 1, col, maxX, maxY);
        dfs(grid, row, col - 1, maxX, maxY);
        dfs(grid, row, col + 1, maxX, maxY);
        return 1;
    }

    // 深度优先
    private static int solveByFloodFillDFS2(int[][] grid) {
        int maxX, maxY;
        if (grid == null || (maxX = (grid.length)) == 0 ||
                (maxY = (grid[0].length)) == 0) return 0;

        Set<Point> visited = new HashSet<>();
        int numIslands = 0;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                numIslands += floodFillDFS(grid, i, j, visited, maxX, maxY);
            }
        }
        return numIslands;
    }

    private static int floodFillDFS(int[][] grid, int row, int col, Set<Point> visited, int maxX, int maxY) {
        if (!isValid(grid, row, col, visited, maxX, maxY)) {
            return 0;
        }
        visited.add(new Point(row, col));
        for (int i = 0; i < maxY; i++) {
            floodFillDFS(grid, row + dx[i], col + dy[i], visited, maxX, maxY);
        }
        return 1;
    }

    private static boolean isValid(int[][] grid, int row, int col, Set<Point> visited, int maxX, int maxY) {
        return 0 <= row && row < maxX && 0 <= col && col < maxY
                && grid[row][col] != 0 && !visited.contains(new Point(row, col));
    }
}
