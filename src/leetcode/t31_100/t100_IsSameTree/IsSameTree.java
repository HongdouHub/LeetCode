package leetcode.t31_100.t100_IsSameTree;

import leetcode.preparation.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static leetcode.preparation.treenode.PrepareTreeNode.generate;

/**
 * 100. 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class IsSameTree {

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
        System.out.println(0 ^ 0);

        System.out.println(true ^ true);
        System.out.println(true ^ false);
        System.out.println(false ^ false);
        System.out.println("-----------------");

        System.out.println(isSameTree1(generate(new Integer[] {1, 2, 3}), generate(new Integer[] {1, 2, 3})));
        System.out.println(isSameTree2(generate(new Integer[] {1, 2, 3}), generate(new Integer[] {1, 2, 3})));
    }

    /**
     * 深度优先
     *
     * 时间复杂度：O(min(m,n))，
     * 其中 m 和 n 分别是两个二叉树的节点数。
     * 对两个二叉树同时进行深度优先搜索，
     * 只有当两个二叉树中的对应节点都不为空时才会访问到该节点，
     * 因此被访问到的节点数不会超过较小的二叉树的节点数。
     *
     *
     * 空间复杂度：O(min(m,n))
     * 其中 m 和 n 分别是两个二叉树的节点数。
     * 空间复杂度取决于递归调用的层数，
     * 递归调用的层数不会超过较小的二叉树的最大高度，
     * 最坏情况下，二叉树的高度等于节点数。
     */
    private static boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (!p.val.equals(q.val)) {
            return false;
        }

        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }

    /**
     * 广度优先
     *
     * 时间复杂度：O(min(m,n))
     * 其中 m 和 n 分别是两个二叉树的节点数。
     * 对两个二叉树同时进行广度优先搜索，只有当两个二叉树中的对应节点都不为空时才会访问到该节点，
     * 因此被访问到的节点数不会超过较小的二叉树的节点数。
     *
     * 空间复杂度：O(min(m,n))
     * 其中 m 和 n 分别是两个二叉树的节点数。
     * 空间复杂度取决于队列中的元素个数，队列中的元素个数不会超过较小的二叉树的节点数。
     */
    private static boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queueP = new LinkedList<TreeNode>();
        Queue<TreeNode> queueQ = new LinkedList<TreeNode>();

        queueP.offer(p);
        queueQ.offer(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {

            TreeNode poll1 = queueP.poll();
            TreeNode poll2 = queueQ.poll();

            if (!poll1.val.equals(poll2.val)) {
                return false;
            }

            TreeNode left1 = poll1.left;
            TreeNode right1 = poll1.right;

            TreeNode left2 = poll2.left;
            TreeNode right2 = poll2.right;

            if (left1 == null ^ left2 == null) {
                // 不相等
                return false;
            }

            if (right1 == null ^ right2 == null) {
                // 不相等
                return false;
            }

            if (left1 != null && left2 != null) {
                queueP.offer(left1);
                queueQ.offer(left2);
            }

            if (right1 != null && right2 != null) {
                queueP.offer(right1);
                queueQ.offer(right2);
            }
        }

        return queueP.isEmpty() && queueQ.isEmpty();
    }
}
