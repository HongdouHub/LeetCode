package leetcode.t201_250.t204_CountPrimes;

import java.util.Arrays;

/**
 * 204. 计数质数
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes1(10));
        System.out.println(countPrimes2(10));

        System.out.println(countPrimes1(3));
        System.out.println(countPrimes2(3));
    }

    /**
     * 暴力求解
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static int countPrimes1(int n) {
        if (n <= 2) {
            return 0;
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    // 判断整数 n 是否是素数
    private static boolean isPrime(int n) {
//        for (int i = 2; i < n; i++) {
//            // 有其他整除因子
//            if (n % i == 0) {
//                return false;
//            }
//        }

        for (int i = 2; i * i <= n; i++) {
            // 有其他整除因子
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 高效算法 - Sieve of Eratosthenes
     *
     * 时间复杂度：O(N * loglogN)
     * 空间复杂度：O(1)
     */
    private static int countPrimes2(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // 优化一： i < sqrt(n)
        for (int i = 2; i * i <= n; i++) {
//        for (int i = 2; i < n; i++) {

            if (isPrime[i]) {
                // 优化二：去除计算冗余
                for (int j = i * i; j < n; j += i) {
//                for (int j = i * 2; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

}
