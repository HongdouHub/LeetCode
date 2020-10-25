package leetcode.t700_800.t773_SlidingPuzzle;

import utils.TextUtils;

import java.util.*;

/**
 * 773. 滑动谜题
 *
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，
 * 用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 *
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，
 * 如果不能解开谜板，则返回 -1 。
 *
 * 示例：
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 *
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 */
public class SlidingPuzzle {

    public static void main(String[] args) {
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}})); // 1
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}})); // -1
        System.out.println(slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}})); // 5
        System.out.println(slidingPuzzle(new int[][]{{3, 2, 4}, {1, 5, 0}})); // 14
    }

    private static int slidingPuzzle(int[][] board) {
        int horizontalSize, verticalSize;
        if (board == null || (horizontalSize = board.length) == 0 ||
                (verticalSize = board[0].length) == 0) {
            return -1;
        }

        StringBuilder startBuilder = new StringBuilder();
        for (int i = 0; i < horizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                startBuilder.append(board[i][j]);
            }
        }

        int totalSize = horizontalSize * verticalSize;
        StringBuilder targetBuilder = new StringBuilder();
        for (int i = 1; i < totalSize; i++) {
            targetBuilder.append(i);
        }
        targetBuilder.append('0');

        // 包含上下左右四个方向
        int[][] neighbourRules = new int[totalSize][4];
        for (int i = 0; i < horizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                int index = verticalSize * i + j;

                neighbourRules[index][0] = (i - 1 >= 0) ? (index - verticalSize): -1;
                neighbourRules[index][1] = (j - 1 >= 0) ? (index - 1) : -1;
                neighbourRules[index][2] = (j + 1 < verticalSize) ? (index + 1) : -1;
                neighbourRules[index][3] = (i + 1 < horizontalSize) ? (index + verticalSize) : -1;
            }
        }

        return bfs(startBuilder.toString(), targetBuilder.toString(), neighbourRules);
    }

    private static int bfs(String start, String target, int[][] neighbourRules) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visitedSet = new HashSet<>();

        queue.offer(start);
        visitedSet.add(start);

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String poll = queue.poll();

                if (TextUtils.equals(poll, target)) {
                    return step;
                }

                if (TextUtils.isEmpty(poll) || !poll.contains("0")) {
                    return -1;
                }

                // 找到数字 0 的索引
                int zeroIndex = 0;
                while (poll.charAt(zeroIndex) != '0') {
                    zeroIndex++;
                }

                int[] neighbourRule = neighbourRules[zeroIndex];

                for (int j = 0; j < 4; j++) {
                    if (neighbourRule[j] == -1) {
                        continue;
                    }

                    String neighbour = swap(poll, zeroIndex, neighbourRule[j]);

                    // 防止走回头路
                    if (!visitedSet.contains(neighbour)) {
                        queue.offer(neighbour);
                        visitedSet.add(neighbour);
                    }
                }
            }

            // 划重点，更新步数在此处
            step++;
        }
        return -1;
    }

    private static String swap(String raw, int start, int end) {
        char[] chars = raw.toCharArray();
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        return new String(chars);
    }

}
