package leetcode.t101_150.t102_BinaryTreeLevelOrder;

import leetcode.preparation.treenode.PrepareTreeNode;
import leetcode.preparation.treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层级遍历
 *
 * 1. 广度优先遍历
 * 2. 深度优先遍历
 */
public class BinaryTreeLevelOrder {

    public static void main(String[] args) {
        TreeNode node = PrepareTreeNode.generate(3, 9, 20, null, null, 15, 7);
        if (node == null) {
            System.out.println("输入有误");
            return;
        }

        List<List<Integer>> bfsList = solveByBFS(node);
        printData(bfsList);

        List<List<Integer>> dfsList = solveByDFS(node);
        printData(dfsList);
    }

    /**
     * 广度优先遍历
     */
    private static List<List<Integer>> solveByBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // visited = new HashSet(root); 用于记录是否被访问过

        int levelSize;
        List<Integer> currentLevel;
        TreeNode node;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                if ((node = queue.poll()) != null) {
                    currentLevel.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    /**
     * 深度优先遍历
     */
    private static List<List<Integer>> solveByDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 0, result);
        return result;
    }

    private static void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return;

        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }

    private static void printData(List<List<Integer>> data) {
        if (data == null) return;

        for (List<Integer> list : data) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
