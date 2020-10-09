package leetcode.t887_SuperEggDrop.labuladong;

import leetcode.t887_SuperEggDrop.AbstractSuperEggDrop;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop2 extends AbstractSuperEggDrop {

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
     * 递归 + 备忘录 + 二分法
     *
     * @param K 鸡蛋数
     * @param N 楼层数
     *
     * 时间复杂度： O(n * k · log n)
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

        int left = 1;
        int right = N;

        while (left <= right) {
            int middle = left + ((right - left) >> 1);

            int breakCount = dp(K - 1, middle - 1, memory); // 碎了
            int notBreakCount = dp(K, N - middle, memory);  // 没碎

//            result = Math.min(result, Math.max(breakCount, notBreakCount) + 1);

            if (breakCount > notBreakCount) {
                right = middle - 1;
                result = Math.min(result, breakCount + 1);
            } else {
                left = middle + 1;
                result = Math.min(result, notBreakCount + 1);
            }
        }

        memory.put(key, result);
        return result;
    }


}
