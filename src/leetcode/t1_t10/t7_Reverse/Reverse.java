package leetcode.t1_t10.t7_Reverse;

/**
 * 7. 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        int result = 0;
        int pop = 0;
        while (x != 0) {
            pop = x % 10;

            if (result > Integer.MAX_VALUE / 10 ||
                    result ==  Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 ||
                    result == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }

            result = result * 10 + pop;

            x = x / 10;
        }
        return result;
    }

}
