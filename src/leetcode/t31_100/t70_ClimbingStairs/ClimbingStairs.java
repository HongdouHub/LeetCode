package leetcode.t31_100.t70_ClimbingStairs;

import leetcode.preparation.MethodBuilder;

import static utils.ConsoleUtils.println;

/**
 * 70. 爬楼梯
 *
 * <p>
 * 电梯：elevator
 * 扶梯：escalator
 */
@SuppressWarnings("all")
public class ClimbingStairs {

    public static void main(String[] args) {
        test("climbStairs1");
        test("climbStairs2");
        test("climbStairs3");
    }

    private static void test(String methodName) {
        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(ClimbingStairs.class)
                .setMethodName(methodName)
                .setParameterTypes(int.class)
                .build();

        System.out.println(String.format("-------------%s------------", methodName));
        println(builder.invoke(2));   // 2
        println(builder.invoke(3));   // 3
        println(builder.invoke(4));   // 5
        println(builder.invoke(5));   // 8
        println(builder.invoke(6));   // 13
        println(builder.invoke(50));  //
        System.out.println("----------------------------------------\n");
    }

    /**
     * 递归斐波那契数列方法 - 超时
     *
     * f(n) = f(n - 1) + f(n -2)
     * <p>
     * f(0) = f(1) = 1
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int climbStairs1(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 递归斐波那契数列方法 - 优化【0ms(100.00%) - 34.9MB(98.67%)】
     *
     * f(n) = f(n - 1) + f(n -2)
     * <p>
     * f(0) = f(1) = 1
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int climbStairs2(int n) {
        Integer[] memory = new Integer[n + 1];
        return solve(n, memory);
    }

    private static int solve(int n, Integer[] memory) {
        if (n == 0 || n == 1) {
            return memory[n] = 1;
        } else if (memory[n] == null) {
            return memory[n] = solve(n-1, memory) + solve(n-2, memory);
        } else {
            return memory[n];
        }

//        return (n == 0 || n == 1) ? memory[n] = 1 :
//                (memory[n] != null) ? memory[n] :
//                        (memory[n] = solve(n - 1, memory) +
//                                solve(n - 2, memory));
    }

    /**
     * 动态规划 - 【0ms(100.00%) - 34.9MB(98.87%)】
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static long climbStairs3(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        // 1. 状态定义： dp[i] 表示第i层楼梯的最大到达方式
        int[] dp = new int[n];

        // 2. 初始化状态
        dp[0] = 1;
        dp[1] = 2;

        // 3. 思考状态转移方程
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }

}
