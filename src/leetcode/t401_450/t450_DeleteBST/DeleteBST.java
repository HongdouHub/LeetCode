package leetcode.t401_450.t450_DeleteBST;

import leetcode.preparation.MethodBuilder;
import leetcode.preparation.treenode.TreeNode;

import static leetcode.preparation.treenode.PrepareTreeNode.generate;
import static leetcode.preparation.treenode.PrepareTreeNode.print;

/**
 * 450. 删除二叉搜索树中的节点
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 */
@SuppressWarnings("all")
public class DeleteBST {

    public static void main(String[] args) {
//        test("deleteNode1");
        test("deleteNode2");
    }

    private static void test(String methodName) {
        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(DeleteBST.class)
                .setMethodName(methodName)
                .setParameterTypes(new Class[]{TreeNode.class, int.class})
                .build();

        System.out.println(String.format("-------------%s------------", methodName));
        TreeNode treeNode = generate(5, 3, 6, 2, 4, null, 7);
        print(treeNode);
        print((TreeNode) builder.invoke(treeNode, 3));
        print((TreeNode) builder.invoke(treeNode, 5));
        print((TreeNode) builder.invoke(treeNode, 8));
        System.out.println("----------------------------------------\n");
    }

    /**
     * 时间复杂度：O(logN)
     * 空间复杂度：O(H)，递归时堆栈使用的空间，H 是树的高度。
     */
    private static TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        TreeNode removeNode = getNode(root, key);
        if (removeNode == null) {
            return root;
        }

        // 前驱节点
        TreeNode predecessor = removeNode.getPredecessor();
        if (predecessor != null) {
            removeNode.val = predecessor.val;
            removeNode.left = deleteNode1(removeNode.left, removeNode.val);
            clearNode(removeNode.left, removeNode.val);
            return root;
        }

        // 后继节点
        TreeNode successor = removeNode.getSuccessor();
        if (successor != null) {
            removeNode.val = successor.val;
            removeNode.right = deleteNode1(removeNode.right, removeNode.val);
            clearNode(removeNode.right, removeNode.val);
            return root;
        }

        return root;
    }

    private static TreeNode getNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return root;
        }

        TreeNode left = getNode(root.left, key);
        if (left != null) {
            return left;
        }

        TreeNode right = getNode(root.right, key);
        if (right != null) {
            return right;
        }

        return null;
    }

    private static TreeNode clearNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return root;
        }

        TreeNode left = clearNode(root.left, key);
        if (left != null) {
            root.left = null;
            return null;
        }

        TreeNode right = clearNode(root.right, key);
        if (right != null) {
            root.right = null;
            return null;
        }
        return null;
    }

    private static TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.val) {
            root.right = deleteNode2(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode2(root.left, key);
        } else {
            // 1. 找到了要删除的节点
            if (root.left != null) {
                // 1.1 要删除的节点不是叶子节点，且有左节点（用前驱节点）

                TreeNode predecessor = root.getPredecessor();
                root.val = predecessor.val;
                root.left = deleteNode2(root.left, root.val);
            } else if (root.right != null) {
                // 1.2 要删除的几点不是叶子节点且拥有右节点（用后继节点）

                TreeNode successor = root.getSuccessor();
                root.val = successor.val;
                root.right = deleteNode2(root.right, root.val);
            } else {
                // 1.3 要删除的节点为叶子节点，可以直接删除

                root = null;
            }
        }
        return root;
    }

}
