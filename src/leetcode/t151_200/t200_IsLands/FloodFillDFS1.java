package leetcode.t151_200.t200_IsLands;

/**
 * 染色法
 */
public class FloodFillDFS1 implements INumIslands {

    @Override
    public int numIslands(char[][] grid) {
        int maxX, maxY;
        if (grid == null || (maxX = (grid.length)) == 0 ||
                (maxY = (grid[0].length)) == 0) return 0;

        int numIslands = 0;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (grid[i][j] == '1') {
                    numIslands += dfs(grid, i, j, maxX, maxY);
                }
            }
        }
        return numIslands;
    }

    private static int dfs(char[][] grid, int row, int col, int maxX, int maxY) {
        if (row < 0 || row >= maxX || col < 0 || col >= maxY || grid[row][col] == '0') {
            return 0;
        }
        grid[row][col] = '0';
        dfs(grid, row - 1, col, maxX, maxY);
        dfs(grid, row + 1, col, maxX, maxY);
        dfs(grid, row, col - 1, maxX, maxY);
        dfs(grid, row, col + 1, maxX, maxY);
        return 1;
    }
}
