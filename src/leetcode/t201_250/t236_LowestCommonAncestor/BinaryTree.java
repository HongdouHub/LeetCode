package leetcode.t201_250.t236_LowestCommonAncestor;

import leetcode.preparation.treenode.PrepareTreeNode;
import leetcode.preparation.treenode.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 *
 * 沟通确认：
 *  （1） p 或 q 能否为 null；若有为null值的，将如何处理
 *  （2） p 或 q 能否出现不在二叉树中的数据？ 若有，将如何处理
 *
 * 方法一： 暴力求出p 和 q 的路径，遍历路径得到最后一个重合的结点 O(3n)
 * 方法二： 递归 O(n)
 */
public class BinaryTree {

    /**
     *       6
     *   2       8
     * 0   4   7   9
     *    3 5
     */
    public static void main(String[] args) {
        TreeNode root = PrepareTreeNode.generate(
                6, 2, 8, 0, 4, 7, 9, null, 3, 5);

        // 查找7和9的公共祖先，为8
        TreeNode result = lowestCommonAncestor(root, root.get(5), root.get(6));
        System.out.println(result != null ? result.val : null);
    }

    /**
     * 深度优先遍历
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(log n)
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.equals(p) || root.equals(q)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left == null ? right :
                right == null ? left : root;
    }

}
