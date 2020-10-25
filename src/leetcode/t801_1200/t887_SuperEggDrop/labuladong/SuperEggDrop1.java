package leetcode.t801_1200.t887_SuperEggDrop.labuladong;

import leetcode.t801_1200.t887_SuperEggDrop.AbstractSuperEggDrop;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop1 extends AbstractSuperEggDrop {

    private static class Node {
        int k;
        int n;

        Node(int k, int n) {
            this.k = k;
            this.n = n;
        }
    }

    @Override
    public int superEggDrop(int K, int N) {
        int depth = super.superEggDrop(K, N);
        if (depth >= 0) {
            return depth;
        }

        Map<Node, Integer> memory = new HashMap<>();
        return dp(K, N, memory);
    }

    /**
     * 递归 + 备忘录 - 超时
     *
     * @param K 鸡蛋数
     * @param N 楼层数
     *
     * 时间复杂度： O(n ^ 2 * k)
     * 空间复杂度： O(n * k)
     */
    private static int dp(int K, int N, Map<Node, Integer> memory) {

        if (K == 1) return N;
        if (N == 0) return 0;

        Node key = new Node(K, N);
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1; i++) {
            // 求最少实验次数
            result = Math.min(result,
                    // 最坏情况下扔鸡蛋的次数
                    Math.max(
                            dp(K, N - i, memory),    // 没碎
                            dp(K - 1, i - 1, memory) // 碎了
                    ) + 1
            );
        }

        memory.put(key, result);
        return result;
    }


}
