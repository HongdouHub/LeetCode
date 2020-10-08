package leetcode.t875_MinEatingSpeed;

import static leetcode.t875_MinEatingSpeed.TestData.TEST_DATA;

/**
 * 875. 爱吃香蕉的珂珂
 *
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。
 * 警卫已经离开了，将在 H 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。
 * 每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 提示：
 *
 *     1 <= piles.length <= 10^4
 *     piles.length <= H <= 10^9
 *     1 <= piles[i] <= 10^9
 *
 * 示例 1：
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 *
 * 示例 2：
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 *
 * 示例 3：
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 */
@SuppressWarnings("all")
public class MinEatingSpeed {

    public static void main(String[] args) {
        System.out.println(Math.ceil(2.1));

        System.out.println(minEatingSpeed(new int[] {3,6,7,11}, 8));        // 4
        System.out.println(minEatingSpeed(new int[] {30,11,23,4,20}, 5));   // 30
        System.out.println(minEatingSpeed(new int[] {30,11,23,4,20}, 6));   // 23
        System.out.println(minEatingSpeed(TEST_DATA, 63939633));            // 78332
    }

    /**
     * 二分法
     *
     * 时间复杂度：O(nlogm)，其中 n 是香蕉堆的数量，m 最大的香蕉堆的大小
     * 空间复杂度：O(1)
     */
    private static int minEatingSpeed(int[] piles, int H) {
        int length;
        if (piles == null || (length = piles.length) == 0 || H <= 0) {
            return -1;
        }

        int low = 1;
        int high = Integer.MAX_VALUE;

        while (low < high) {
            int middle = low + ((high - low) >> 1);

            if (canEatOnTime(piles, H, middle)) {
                // 能在 H 天内吃完所有的香蕉
                high = middle;
            } else {
                // 加速
                low = middle + 1;
            }
        }
        return low;
    }

    /**
     * 判断在 speed 速度下，在H天是否能吃掉所有的香蕉
     */
    private static boolean canEatOnTime(int[] piles, int H, int speed) {
        int sum = 0;
        int length = piles.length;
        for (int i = 0; i < length; i++) {
            // 向上取整
            sum += Math.ceil((double) piles[i] / speed);
        }
        return sum <= H;
    }

}
