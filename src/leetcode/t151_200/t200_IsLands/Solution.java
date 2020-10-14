package leetcode.t151_200.t200_IsLands;

import static utils.ConsoleUtils.println;

/**
 * 200. 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，
 * 请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
@SuppressWarnings("all")
public class Solution {

    public static void main(String[] args) {
        test(new FloodFillBFS());   // 染色法- 广度优先
        test(new FloodFillDFS1());  // 染色法- 深度优先
        test(new FloodFillDFS2());  // 染色法- 深度优先
        test(new UnionFind());      // 并查集法- 深度优先
    }

    private static void test(INumIslands numIslands) {
        System.out.println(String.format("----------%s---------", numIslands.getClass().getSimpleName()));

//        println(numIslands.numIslands(new char[][]{
//                new char[]{'1', '1', '0', '0'},
//                new char[]{'1', '1', '0', '0'},
//                new char[]{'0', '0', '1', '0'},
//                new char[]{'0', '0', '0', '1'}
//        }));

        println(numIslands.numIslands(new char[][]{
                new char[]{'1'}
        }));

        println(numIslands.numIslands(new char[][]{
                new char[]{'0'}
        }));
        System.out.println("---------------------------\n");
    }

    private static char[][] getLandData() {
        return new char[][]{
                new char[]{'1', '1', '0', '0'},
                new char[]{'1', '1', '0', '0'},
                new char[]{'0', '0', '1', '0'},
                new char[]{'0', '0', '0', '1'}
        };
    }
}
