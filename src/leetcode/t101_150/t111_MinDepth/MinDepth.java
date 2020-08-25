package leetcode.t101_150.t111_MinDepth;

import javafx.util.Pair;
import leetcode.preparation.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static leetcode.preparation.treenode.PrepareTreeNode.generate;

@SuppressWarnings("all")
public class MinDepth {

    public static void main(String[] args) {
        System.out.println(minDepth1(generate(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(minDepth1(generate(new Integer[]{1, 2})));
        System.out.println(minDepth1(generate(new Integer[]{1, 2, null, 3, null, null, null, 4, null, null, null, null, null, null, null, 5})));

        System.out.println(minDepth2(generate(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(minDepth2(generate(new Integer[]{1, 2})));
        System.out.println(minDepth2(generate(new Integer[]{1, 2, null, 3, null, null, null, 4, null, null, null, null, null, null, null, 5})));
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
