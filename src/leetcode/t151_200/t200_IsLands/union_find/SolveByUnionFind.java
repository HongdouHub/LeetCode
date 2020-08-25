package leetcode.t151_200.t200_IsLands.union_find;

import leetcode.t151_200.t200_IsLands.IsLands;

/**
 * 并查集
 */
public class SolveByUnionFind extends IsLands {

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
