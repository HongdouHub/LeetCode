package leetcode.preparation.treenode;

import java.util.LinkedList;
import java.util.Queue;

public class PrepareTreeNode {

    /**
     * 生成二叉树
     */
    public static TreeNode generate(Integer... array) {
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
    public static TreeNode generateBST(Integer... array) {
        if (array == null) return null;
        TreeNode result = null;

        for (Integer integer : array) {
            result = insertIntoBST(result, integer);
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

        int maxLevel = getMaxDepth(treeNode);
        int maxLevelCount = ((int) Math.pow(2, maxLevel) - 1) * 6 + 4;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                current++;

                if (level != maxLevel) {
                    if (i == 0) {
                        if ((size & 1) == 1) { // 奇数（第一行）
                            printSpace((maxLevelCount - 4) / 2);
                        } else { // 偶数个
                            printSpace((maxLevelCount - ((size - 1) * 6 + 4)) / 2);
                        }
                    }
                }


                if (poll == null) {
                    System.out.print("null, ");
                } else {
                    String format = " %2d " + ((i == size - 1) ? "" : ", ");
                    System.out.print(String.format(format, poll.val));
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }

            // 补充上一层为null节点造成本层null打印的缺失
            double currentLevelCount = Math.pow(2, level);
            if (current < currentLevelCount) {
                StringBuilder builder = new StringBuilder();
                for (double i = 0; i < currentLevelCount - current; i++) {
                    builder.append("null, ");
                }
                System.out.print(builder.substring(0, builder.length() - 2));
            }

            level++;
            current = 0;
            System.out.println();
        }
        System.out.println("\n-----------------");
    }

    private static int getMaxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        return 1 + Math.max(getMaxDepth(treeNode.left), getMaxDepth(treeNode.right));
    }

    private static void printSpace(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(" ");
        }
    }
}
