package leetcode.t31_100.t98_ValidateBST;

import leetcode.preparation.MethodBuilder;
import leetcode.preparation.treenode.TreeNode;

import static leetcode.preparation.treenode.PrepareTreeNode.generate;

/**
 * 校验二叉树是否为二叉排序树
 *
 * 1、中序遍历 -> 从小到大 O(n)
 * 2、递归：左子树的最大值 < 根结点；  右子树的最小值 > 根结点 O(n)
 */
public class ValidBST {

    public static void main(String[] args) {
        test("isValidBST1");
        test("isValidBST2");
    }

    private static void test(String methodName) {
        MethodBuilder build = new MethodBuilder.Builder()
                .setClazz(ValidBST.class)
                .setMethodName(methodName)
                .setParameterTypes(new Class[]{TreeNode.class})
                .build();

        System.out.println(String.format("----------%s---------", methodName));
        System.out.println(build.invoke(generate(3, 1, 5, null, 2)));
        System.out.println(build.invoke(generate(5, 1, 4, null, null, 3, 6)));
        System.out.println(build.invoke(generate(new Integer[]{null})));
        System.out.println("---------------------------\n");
    }

    /**
     * 深度优先递归遍历
     */
    private static boolean isValidBST1(TreeNode root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return isValid(root.left, min, root.val) &&
                isValid(root.right, root.val, max);
    }

    /**
     * 中序遍历
     */
    private static TreeNode pre = null;
    private static boolean isValidBST2(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST2(root.left)) return false;

        if (pre != null && pre.val >= root.val) return false;

        pre = root;
        return isValidBST2(root.right);
    }

}
