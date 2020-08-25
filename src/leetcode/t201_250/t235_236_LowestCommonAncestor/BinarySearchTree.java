package leetcode.t201_250.t235_236_LowestCommonAncestor;

import leetcode.preparation.treenode.PrepareTreeNode;
import leetcode.preparation.treenode.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 *
 * 沟通确认：
 *  （1） p 或 q 能否为 null；若有为null值的，将如何处理
 *  （2） p 或 q 能否出现不在二叉树中的数据？ 若有，将如何处理
 *
 * 方法一： 暴力求出p 和 q 的路径，遍历路径得到最后一个重合的结点 O(3n)
 * 方法二： 递归 O(n)
 * 方法三： while
 */
public class BinarySearchTree {

    /**
     *       6
     *   2       8
     * 0   4   7   9
     *    3 5
     */
    public static void main(String[] args) {
        TreeNode root = PrepareTreeNode.generate(
                new Integer[]{6, 2, 8, 0, 4, 7, 9, null, 3, 5});

        TreeNode result = lowestCommonAncestorByRecursion(root, new TreeNode(7), new TreeNode(9));
        System.out.println(result != null ? result.val : null);


        TreeNode result2 = lowestCommonAncestorByWhile(root, new TreeNode(7), new TreeNode(9));
        System.out.println(result2 != null ? result2.val : null);
    }

    private static TreeNode lowestCommonAncestorByRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p == null) return q;
        if (q == null) return p;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorByRecursion(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorByRecursion(root.right, p, q);
        }
        return root;
    }

    private static TreeNode lowestCommonAncestorByWhile(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode head = root;
        while (head != null) {
            if (p == null) {
                head = q;
                break;
            }
            if (q == null) {
                head = p;
                break;
            }

            if (p.val < head.val && q.val < head.val) {
                head = head.left;
            } else if (p.val > head.val && q.val > head.val) {
                head = head.right;
            } else {
                break;
            }
        }
        return head;
    }
}
