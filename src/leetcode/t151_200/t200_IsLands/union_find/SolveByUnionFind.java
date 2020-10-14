package leetcode.t151_200.t200_IsLands.union_find;

/**
 * 并查集
 */
public class SolveByUnionFind {

    private static int[][] getLandData() {
        return new int[][]{
                new int[]{1, 1, 0, 0},
                new int[]{1, 1, 0, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 0, 1}
        };
    }

    public static void main(String[] args) {
        int[][] landData = getLandData();

        System.out.println(solveByUnionFind(landData));
    }

    private static int solveByUnionFind(int[][] grid) {
        int maxX, maxY;
        if (grid == null || (maxX = (grid.length)) == 0 ||
                (maxY = (grid[0].length)) == 0) return 0;



        return 0;
    }

}
