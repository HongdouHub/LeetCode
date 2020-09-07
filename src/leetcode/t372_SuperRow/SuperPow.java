package leetcode.t372_SuperRow;

/**
 * 372. 超级次方
 *
 * 你的任务是计算 a^b 对 1337 取模，
 * a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * 示例 1:
 * 输入: a = 2, b = [3]
 * 输出: 8
 */
public class SuperPow {

    private static final int BASE = 1337;

    public static void main(String[] args) {
        System.out.println(Math.pow(911, 10));
        System.out.println("----------");

        System.out.println(superPow(2, new int[] {3}));
        System.out.println(superPow(2, new int[] {1, 0}));
        System.out.println(superPow(2147483647, new int[] {2, 0, 0}));
    }

    /**
     * 1.   a[1,2,3,4]  = (a[1,2,3]) ^ 10 · a ^ 4
     *
     * 2.   (a * b) % p = (a % p * b % p) % p
     */
    private static int superPow(int a, int[] b) {
        int length;
        if (b == null || (length = b.length) == 0) {
            return 0;
        }

        if (length == 1 && b[0] == 0) {
            return 1;
        }

        int result = 1;
        for (int i = 0; i < length; i++) {
            result = myPow(a, b[i]) * myPow(result, 10);
        }
        return result % BASE;
    }

    /**
     * 计算 (a ^ b) mod 1337
     */
    private static int myPow(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result = (result % BASE) * (a % BASE);
        }
        return result % BASE;
    }

}
