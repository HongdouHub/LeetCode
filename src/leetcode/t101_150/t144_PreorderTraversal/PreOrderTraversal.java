package leetcode.t101_150.t144_PreorderTraversal;

import leetcode.preparation.treenode.TreeNode;
import utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

import static leetcode.preparation.treenode.PrepareTreeNode.generate;

/**
 * 144. 二叉树的前序遍历
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * 示例:
 *      输入: [1,null,2,3]
 *         1
 *          \
 *           2
 *          /
 *         3
 *      输出: [1,2,3]
 */
@SuppressWarnings("all")
public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.right = t2;
        t2.left = t3;

        System.out.println(GsonUtil.array2Json(preorderTraversal(t1)));
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private static void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }

}
