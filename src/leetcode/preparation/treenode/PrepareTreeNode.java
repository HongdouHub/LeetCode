package leetcode.preparation.treenode;

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

}
