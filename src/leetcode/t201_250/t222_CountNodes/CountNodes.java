package leetcode.t201_250.t222_CountNodes;

import leetcode.preparation.treenode.TreeNode;

import static leetcode.preparation.treenode.PrepareTreeNode.generate;

/**
 * 222. 完全二叉树的节点个数
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class CountNodes {

    public static void main(String[] args) {
        System.out.println(countNodes1(generate(new Integer[] {1, 2, 3, 4, 5, 6})));
        System.out.println(countNodes2(generate(new Integer[] {1, 2, 3, 4, 5, 6})));
    }

    /**
     * 直接暴力递归
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(d)=O(logN)
     */
    private static int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }

    /**
     * 深度优先遍历（找树高） + 二分查找（查找叶子结点是否存在）
     *
     * 时间复杂度：O(d^2)=O(log2N)，其中 d 指的是树的高度。
     * 空间复杂度：O(1)
     */
    private static int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = getNodeDepth(root);
        if (depth == 0) {
            return 1;
        }

        int left = 0;
        int right = (int) (Math.pow(2, depth) - 1);
        int pivot;

        while (left <= right) {
            pivot = (left + right) >> 1;

            if (isNodeExist(root, pivot, depth)) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return (int) (Math.pow(2, depth) - 1 + left);
    }

    private static int getNodeDepth(TreeNode root) {
        int depth = 0;
        while (root.left != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    private static boolean isNodeExist(TreeNode root, int pivot, int depth) {
        int left = 0;
        int right = (int) (Math.pow(2, depth) - 1);
        int middle;

        for (int i = 0; i < depth; i++) {
            middle = (left + right) >> 1;

            if (pivot <= middle) {

                // 查找的下标 < 遍历过程的下标
                right = middle;
                root = root.left;
            } else {

                // 查找的下标 > 遍历过程的下标
                left = middle + 1;
                root = root.right;
            }
        }

        return root != null;
    }
}
