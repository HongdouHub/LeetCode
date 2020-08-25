package leetcode.t31_100.t98_ValidateBST;

import leetcode.preparation.treenode.PrepareTreeNode;
import leetcode.preparation.treenode.TreeNode;

/**
 * 校验二叉树是否为二叉排序树
 *
 * 1、中序遍历 -> 从小到大 O(n)
 * 2、递归：左子树的最大值 < 根结点；  右子树的最小值 > 根结点 O(n)
 */
public class ValidBST {

    public static void main(String[] args) {
        testInOrder();

        testRecursion();
    }

    private static void testRecursion() {
        TreeNode root1 = PrepareTreeNode.generate(
                new Integer[]{3, 1, 5, null, 2});
        System.out.println(validBSTByRecursion(root1));

        TreeNode root2 = PrepareTreeNode.generate(
                new Integer[]{5, 1, 4, null, null, 3, 6});
        System.out.println(validBSTByRecursion(root2));

        TreeNode root3 = PrepareTreeNode.generate(
                new Integer[]{null});
        System.out.println(validBSTByRecursion(root3));
    }

    private static void testInOrder() {
        TreeNode root1 = PrepareTreeNode.generate(
                new Integer[]{3, 1, 5, null, 2});
        System.out.println(validBST(root1));

        TreeNode root2 = PrepareTreeNode.generate(
                new Integer[]{5, 1, 4, null, null, 3, 6});
        System.out.println(validBST(root2));

        TreeNode root3 = PrepareTreeNode.generate(
                new Integer[]{null});
        System.out.println(validBST(root3));
    }

    // 中序遍历
    private static TreeNode pre = null;
    private static boolean validBST(TreeNode root) {
        if (root == null)
            return true;
        if (!validBST(root.left))
            return false;
        if (pre != null && pre.val >= root.val)
            return false;

        pre = root;
        return validBST(root.right);
    }

    // 普通递归
    private static boolean validBSTByRecursion(TreeNode root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return isValid(root.left, min, root.val) &&
                isValid(root.right, root.val, max);
    }

}
