package leetcode.preparation.treenode;

import java.util.LinkedList;
import java.util.Queue;

public class PrepareTreeNode {

    /**
     * 生成二叉树
     */
    public static TreeNode generate(Integer[] array) {
        if (array == null) return null;
        return createBinaryTreeByArray(array, 0);
    }

    private static TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        if (index < array.length) {
            Integer integer;
            if ((integer = array[index]) != null) {
                TreeNode node = new TreeNode(integer);
                node.left = createBinaryTreeByArray(array, 2 * index + 1);
                node.right = createBinaryTreeByArray(array, 2 * index + 2);
                return node;
            }
        }
        return null;
    }

    /**
     * 生成二叉搜索树
     */
    public static TreeNode generateBST(Integer[] array) {
        if (array == null) return null;
        TreeNode result = null;

        for (int i = 0; i < array.length; i++) {
            result = insertIntoBST(result, array[i]);
        }
        return result;
    }

    private static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void print(TreeNode treeNode) {
        System.out.println("-----------------");
        int level = 0;
        double current = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if (poll == null) {
                System.out.print("null, ");
            } else {
                System.out.print(poll.val + ", ");
                queue.offer(poll.left);
                queue.offer(poll.right);
            }

            if ((++current) >= Math.pow(2, level)) {
                level++;
                current = 0;
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("-----------------");
    }
}
