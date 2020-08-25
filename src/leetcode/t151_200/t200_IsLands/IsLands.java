package leetcode.t151_200.t200_IsLands;

/**
 * 岛屿的个数
 * <p>
 * 1表示陆地，0表示水
 * <p>
 * 方法一： 染色法
 * 方法二： 并查集
 */
public class IsLands {

    protected static int[][] getLandData() {
        return new int[][]{
                new int[]{1, 1, 0, 0},
                new int[]{1, 1, 0, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 0, 1}
        };
    }
}
