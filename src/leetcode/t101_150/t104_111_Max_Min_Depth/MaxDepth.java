package leetcode.t101_150.t104_111_Max_Min_Depth;

import leetcode.preparation.treenode.PrepareTreeNode;
import leetcode.preparation.treenode.TreeNode;

/**
 * 二叉树的最大深度
 */
public class MaxDepth {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode root = PrepareTreeNode.generate(array);

        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {
        return root == null ? 0 :
                1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
