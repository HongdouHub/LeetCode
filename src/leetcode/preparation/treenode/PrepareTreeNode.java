package leetcode.preparation.treenode;

import leetcode.preparation.linkednode.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class PrepareTreeNode {

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
