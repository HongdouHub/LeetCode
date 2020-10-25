package leetcode.t31_100.t69_Sqrt;

/**
 * 69. x 的平方根
 *
 * 1. 二分法
 * 2. 牛顿迭代法
 */
public class Sqrt {
    private static final double PRECISION = 0.00000000000001;

    public static void main(String[] args) {
        System.out.println(mySqrt(10));

        System.out.println(sqrtByBiSearch(10));
        System.out.println(sqrtByRecursion(10));
    }

    /**
     * 二分查找 - 【1ms(100.00%) - 35.3MB(98.02%)】
     *
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     */
    private static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int middle;

        while (left <= right) {
            middle = left + ((right - left) >> 1);

            if (Math.pow(middle, 2) < x && Math.pow(middle + 1, 2) > x) {
                return middle;
            } else if (x / middle > middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    /**
     * 二分查找法
     */
    private static double sqrtByBiSearch(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        double left = 1;
        double right = x;
        double middle;

        double result = 0;

        while (left <= right) {
            middle = left + (right - left) / 2;
            double division = x / middle;

            if (Math.abs(middle - division) < PRECISION) {
                return middle;
            } else if (middle - division > 0) {
                right = middle;
            } else {
                left = middle;
                result = middle;
            }
        }
        return result;
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
