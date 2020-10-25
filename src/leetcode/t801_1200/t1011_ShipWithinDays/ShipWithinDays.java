package leetcode.t801_1200.t1011_ShipWithinDays;

/**
 * 1011. 在 D 天内送达包裹的能力
 *
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 */
@SuppressWarnings("all")
public class ShipWithinDays {

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(shipWithinDays(new int[] {3,2,2,4,1,4}, 3));
    }

    /**
     * 二分查找
     *
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(1)
     */
    private static int shipWithinDays(int[] weights, int D) {
        int low = 0, high = Integer.MAX_VALUE;

        while (low < high) {
            int middle = (low + high) >> 1;

            if (canShip(weights, D, middle)) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    private static boolean canShip(int[] weights, int D, int K) {
        // currentWeight 表示当前船的可用承载量
        int currentWeight = K;

        for (int weight : weights) {

            if (weight > K) {
                return false;
            }

            if (currentWeight < weight) {

                currentWeight = K;
                D--;
            }
            currentWeight -= weight;
        }

        // 能否在D天内运完
        return D > 0;
    }


}
