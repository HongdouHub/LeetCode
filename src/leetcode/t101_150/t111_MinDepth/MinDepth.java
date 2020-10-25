package leetcode.t101_150.t111_MinDepth;

import javafx.util.Pair;
import leetcode.preparation.MethodBuilder;
import leetcode.preparation.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static leetcode.preparation.treenode.PrepareTreeNode.generate;
import static utils.ConsoleUtils.println;

/**
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */
public class MinDepth {

    public static void main(String[] args) {
        test("minDepth1");
        test("minDepth2");
    }

    private static void test(String methodName) {
        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(MinDepth.class)
                .setMethodName(methodName)
                .setParameterTypes(TreeNode.class)
                .build();

        System.out.println(String.format("-------------%s------------", methodName));
        println(builder.invoke(generate(3, 9, 20, null, null, 15, 7))); // 2
        println(builder.invoke(generate(1, 2)));                        // 2
        println(builder.invoke(generate(1, 2, null, 3, null, null, null, 4,
                null, null, null, null, null, null, null, 5)));         // 5
        System.out.println("----------------------------------------\n");
    }

    /**
     * 深度优先遍历
     *
     * 时间复杂度：我们访问每个节点一次，时间复杂度为 O(N) ，其中 N 是节点个数。
     *
     * 空间复杂度：最坏情况下，整棵树是非平衡的，例如每个节点都只有一个孩子，
     * 递归会调用 N （树的高度）次，因此栈的空间开销是 O(N) 。
     * 但在最好情况下，树是完全平衡的，高度只有 log(N)，
     * 因此在这种情况下空间复杂度只有 O(log(N)) 。
     */
    private static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int depth) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return depth + 1;
        }

        return Math.min(dfs(left, depth + 1), dfs(right, depth + 1));
    }

    /**
     * 广度优先遍历
     *
     * 时间复杂度：我们访问每个节点一次，时间复杂度为 O(N) ，其中 N 是节点个数。
     *
     * 空间复杂度：最坏情况下，整棵树是非平衡的，例如每个节点都只有一个孩子，
     * 递归会调用 N （树的高度）次，因此栈的空间开销是 O(N) 。
     * 但在最好情况下，树是完全平衡的，高度只有 log(N)，
     * 因此在这种情况下空间复杂度只有 O(log(N)) 。
     */
    private static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return bfs(root);
    }

    private static int bfs(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<TreeNode, Integer>(root, 1));

        int minDepth = 1;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> poll = queue.poll();

            TreeNode treeNode = poll.getKey();
            minDepth = poll.getValue();

            // 广度优先遍历，遇到第一个叶子节点即为所求
            if (treeNode.left == null && treeNode.right == null) {
                break;
            }

            if (treeNode.left != null) {
                queue.offer(new Pair<>(treeNode.left, minDepth + 1));
            }

            if (treeNode.right != null) {
                queue.offer(new Pair<>(treeNode.right, minDepth + 1));
            }
        }

        return minDepth;
    }
}
