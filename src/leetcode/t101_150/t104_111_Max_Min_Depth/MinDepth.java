package leetcode.t101_150.t104_111_Max_Min_Depth;

import leetcode.preparation.treenode.PrepareTreeNode;
import leetcode.preparation.treenode.TreeNode;

/**
 * 二叉树的最小深度
 */
public class MinDepth {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode root = PrepareTreeNode.generate(array);

        System.out.println(minDepth(root));
    }

    private static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right);
        if (root.right == null) return minDepth(root.left);

        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        return 1 + Math.min(leftMinDepth, rightMinDepth);
    }
}
