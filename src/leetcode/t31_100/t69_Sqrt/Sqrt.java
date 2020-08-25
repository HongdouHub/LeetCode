package leetcode.t31_100.t69_Sqrt;

/**
 * 求开方
 *
 * 1. 二分法
 * 2. 牛顿迭代法
 */
public class Sqrt {
    private static final double PRECISION = 0.00000000000001;

    public static void main(String[] args) {
        System.out.println(sqrtByBiSearch(10));
        System.out.println(sqrtByRecursion(10));
    }

    /**
     * 二分查找法
     */
    private static double sqrtByBiSearch(int x) {
        if (x == 0 || x == 1) return x;

        double l = 1, r = x, res = 0;
        while (l <= r) {
            double middle = (l + r) / 2;
            double division = x / middle;
            if (Math.abs(middle - division) < PRECISION) {
                return middle;
            } else if (middle - division > 0) {
                r = middle;
            } else {
                l = middle;
                res = middle;
            }
        }
        return res;
    }

    /**
     * 牛顿迭代法
     */
    private static double sqrtByRecursion(int x) {
        double d = (double) x;
        double r = d;

        while (r > d / r) {
            r = (r + d / r) / 2;
        }
        return r;
    }
}
