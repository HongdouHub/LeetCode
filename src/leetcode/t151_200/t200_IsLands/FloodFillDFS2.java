package leetcode.t151_200.t200_IsLands;

import java.util.HashSet;
import java.util.Set;

/**
 * 染色法
 */
public class FloodFillDFS2 implements INumIslands {
    private static int[] dx = new int[] {-1, 1, 0, 0};
    private static int[] dy = new int[] {0, 0, -1, 1};

    @Override
    public int numIslands(char[][] grid) {
        int maxX, maxY;
        if (grid == null || (maxX = (grid.length)) == 0 ||
                (maxY = (grid[0].length)) == 0) return 0;

        Set<Point> visited = new HashSet<>();
        int numIslands = 0;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                numIslands += dfs(grid, i, j, visited, maxX, maxY);
            }
        }
        return numIslands;
    }

    private static int dfs(char[][] grid, int row, int col, Set<Point> visited, int maxX, int maxY) {

        Point point = new Point(row, col);
        if (row < 0 || row >= maxX || col < 0 || col >= maxY ||
                grid[row][col] == '0' || visited.contains(point)) {
            return 0;
        }

        visited.add(new Point(row, col));
        dfs(grid, row - 1, col, visited, maxX, maxY);
        dfs(grid, row + 1, col, visited, maxX, maxY);
        dfs(grid, row, col - 1, visited, maxX, maxY);
        dfs(grid, row, col + 1, visited, maxX, maxY);

//        for (int i = 0; i < maxY; i++) {
//            dfs(grid, row + dx[i], col + dy[i], visited, maxX, maxY);
//        }
        return 1;
    }
}
