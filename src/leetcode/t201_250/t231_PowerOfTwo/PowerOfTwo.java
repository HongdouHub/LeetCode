package leetcode.t201_250.t231_PowerOfTwo;

/**
 * 判断是否是2的指数
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        int n = 1 << 16;
        System.out.println(isPowerOfTwo(n));
    }

    private static boolean isPowerOfTwo(int n) {
        // n & (n - 1) 从右边开始打掉一个1
        return n != 0 && (n & (n - 1)) == 0;
    }

}
