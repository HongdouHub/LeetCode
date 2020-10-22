package leetcode.t21_t30.t29_Divide;

/**
 * 29. 两数相除
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，
 * 例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 */
public class Divide {

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
    }

    private static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            return -dividend;
        }

        int sign = 1;   // 标记位
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        // 都改为负号是因为int 的范围是[-2^32, 2^32-1]，如果a是-2^32，转为正数时将会溢出
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;

        if (a > b) {
            return 0;
        }

        int value = div(a, b);
        return sign == -1 ? -value : value;
    }

    /**
     *
     * @param a 被除数（负值）
     * @param b 除数（负值）
     */
    private static int div(int a, int b) {

        if (a > b) {
            return 0;
        }

        int count = 1;
        int tb = b;

        while (tb + tb >= a && tb + tb < 0) {
            tb += tb;
            count += count;
        }
        return count + div(a - tb, b);
    }

}
