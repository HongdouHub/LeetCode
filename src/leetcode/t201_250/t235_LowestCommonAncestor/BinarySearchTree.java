package leetcode.t201_250.t235_LowestCommonAncestor;

import leetcode.preparation.MethodBuilder;
import leetcode.preparation.treenode.PrepareTreeNode;
import leetcode.preparation.treenode.TreeNode;

import static utils.ConsoleUtils.println;

/**
 * 235. 二叉搜索树的最近公共祖先
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
        test("lowestCommonAncestor1");
        test("lowestCommonAncestor2");
    }

    private static void test(String methodName) {
        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(BinarySearchTree.class)
                .setMethodName(methodName)
                .setParameterTypes(TreeNode.class, TreeNode.class, TreeNode.class)
                .build();

        System.out.println(String.format("-------------%s------------", methodName));
        TreeNode root = PrepareTreeNode.generate(
                6, 2, 8, 0, 4, 7, 9, null, 3, 5);
        println(builder.invoke(root, new TreeNode(7), new TreeNode(9)));    // 8
        System.out.println("----------------------------------------\n");
    }

    /**
     * 深度优先遍历
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(log n)
     */
    private static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == null) return q;
        if (q == null) return p;

        // 同向则递归一层
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor1(root.left, p, q);
        }

        // 同向则递归一层
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor1(root.right, p, q);
        }

        // 否则返回
        return root;
    }

    /**
     * while 循环进行深度遍历
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
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
