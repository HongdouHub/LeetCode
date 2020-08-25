package leetcode.t31_100.t70_ClimbingStairs;

/**
 * 爬楼梯问题
 * <p>
 * 电梯：elevator
 * 扶梯：escalator
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 50;
        Long[] memory = new Long[n + 1];
        long result = solveByFibonacci(n, memory);
        System.out.println(result);

        System.out.println(solveByDynamicProgramming(n));
    }

    /**
     * 递归斐波那契数列方法
     * f(n) = f(n - 1) + f(n -2)
     * <p>
     * f(0) = f(1) = 1
     *
     * @return 到第n阶的总走法个数
     */
    private static long solveByFibonacci(int n, Long[] memory) {
        if (n == 0 || n == 1) {
            return memory[n] = 1L;
        } else if (memory[n] == null) {
            return memory[n] = solveByFibonacci(n-1, memory) + solveByFibonacci(n-2, memory);
        } else {
            return memory[n];
        }

//        return (n == 0 || n == 1) ? memory[n] = 1 :
//                (memory[n] != null) ? memory[n] :
//                        (memory[n] = solveByFibonacci(n - 1, memory) +
//                                solveByFibonacci(n - 2, memory));
    }

    /**
     * 动态规划解法
     */
    private static long solveByDynamicProgramming(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        long[] memory = new long[n];
        memory[0] = 1;
        memory[1] = 2;

        for (int i = 2; i < n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n - 1];
    }

}
