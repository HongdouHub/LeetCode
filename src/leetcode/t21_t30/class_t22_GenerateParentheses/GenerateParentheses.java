package leetcode.t21_t30.class_t22_GenerateParentheses;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 生成括号
 */
public class GenerateParentheses {

    /**
     * 传入 n 计算出 n 组括号对应的不同合法组合
     *
     * 组合大小： 2 * n
     * 每个位置均有 ( 或 ) 选择，对应有 2 ^ 2n 的可能性：
     *   校验合法时，有如下改进：—— O(2^n)
     *      1、 局部不合法，不再递归
     *      2、 左括号只能有 n 个，右括号也只能有 n 个
     */
    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(generateParenthesis1(3)));
        System.out.println(GsonUtil.array2Json(generateParenthesis2(3)));
        System.out.println(GsonUtil.array2Json(generateParenthesis3(3)));
    }

    private static List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        dfs(res, n, n, "");
        return res;
    }

    /**
     * 深度优先遍历（回溯算法）
     */
    private static void dfs(List<String> res, int left, int right, String parse) {
        if (left == 0 && right == 0) {
            res.add(parse);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(res, left - 1, right, parse + "(");
        }

        if (right > 0) {
            dfs(res, left, right - 1, parse + ")");
        }
    }

    private static List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        bfs(res, n, n);
        return res;
    }

    /**
     * 广度优先遍历
     */
    private static void bfs(List<String> res, int left, int right) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", left, right));

        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            if (poll.left == 0 && poll.right == 0) {
                res.add(poll.res);
            }

            if (poll.left > 0) {
                queue.offer(new Node(poll.res + '(', poll.left - 1, poll.right));
            }

            if (poll.right > 0 && poll.left < poll.right) {
                queue.offer(new Node(poll.res + ')', poll.left, poll.right - 1));
            }
        }
    }

    private static class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 动态规划
     */
    private static List<String> generateParenthesis3(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        // 1. 状态定义：dp[i] 表示 使用 i 对括号能够生成的组合
        List<List<String>> dp = new ArrayList<>(n);

        // 2. 初始化状态
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        // 3. 思考状态转移方程
//        dp[i] = "(" + dp[可能的括号对数] + ")" + dp[剩下的括号对数];
//        “可能的括号对数” 与 “剩下的括号对数” 之和得为 i - 1

        for (int i = 1; i <= n; i++) {

            List<String> currentList = new ArrayList<>();

            // “可能的括号对数” j 可以从 0 开始，最多不能超过 i， 即 i - 1
            for (int j = 0; j < i; j++) {

                List<String> list1 = dp.get(j);         // 可能的括号对数
                List<String> list2 = dp.get(i - 1 - j); // 剩下的括号对数

                for (String s1 : list1) {
                    for (String s2 : list2) {
                        currentList.add('(' + s1 + ')' + s2);
                    }
                }
            }
            dp.add(currentList);
        }
        return dp.get(n);
    }
}
