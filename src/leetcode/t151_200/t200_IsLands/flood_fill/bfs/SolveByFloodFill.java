package leetcode.t151_200.t200_IsLands.flood_fill.bfs;

import leetcode.t151_200.t200_IsLands.IsLands;
import leetcode.t151_200.t200_IsLands.Point;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 染色法
 */
public class SolveByFloodFill extends IsLands {
    private static int[] dx = new int[] {-1, 1, 0, 0};
    private static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] landData = getLandData();

        System.out.println(solveByFloodFillBFS(landData));
    }

    // 广度优先
    private static int solveByFloodFillBFS(int[][] grid) {
        int maxX, maxY;
        if (grid == null || (maxX = (grid.length)) == 0 ||
                (maxY = (grid[0].length)) == 0) return 0;

        Set<Point> visited = new HashSet<>();
        int numIslands = 0;

        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                numIslands += floodFillBFS(grid, i, j, visited, maxX, maxY);
            }
        }
        return numIslands;
    }

    private static int floodFillBFS(int[][] grid, int row, int col, Set<Point> visited, int maxX, int maxY) {
        if (!isValid(grid, row, col, visited, maxX, maxY)) {
            return 0;
        }

        Point point = new Point(row, col);
        visited.add(point);
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(point);

        int newX, newY;
        while (!queue.isEmpty()) {
            Point first = queue.remove();
            for (int i = 0; i < maxY; i++) {
                newX = first.x + dx[i];
                newY = first.y + dy[i];
                if (isValid(grid, newX, newY, visited, maxX, maxY)) {
                    Point newPoint = new Point(newX, newY);
                    visited.add(newPoint);
                    queue.add(newPoint);
                }
            }
        }
        return 1;
    }

    private static boolean isValid(int[][] grid, int row, int col, Set<Point> visited, int maxX, int maxY) {
        return 0 <= row && row < maxX && 0 <= col && col < maxY
                && grid[row][col] != 0 && !visited.contains(new Point(row, col));
    }
}
