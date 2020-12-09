package leetcode.t151_200.t145_PostorderTraversal;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true。否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。
 */
@SuppressWarnings("all")
public class Test {

    public static void main(String[] args) {
        System.out.println(verifySquenceOfBST(new int[] {5,7,6,9,11,10,8})); // true
        System.out.println(verifySquenceOfBST(new int[] {7,4,6,5}));         // false
    }

    private static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null) {
            return false;
        }

        return dfs(sequence, 0, sequence.length - 1);
    }

    private static boolean dfs(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }

        // 后序遍历的最后一个结点为根结点
        int root = sequence[end];

        // 在二叉搜索树中左子树的结点均小于根结点
        int i = 0;
        for (; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        // 在二叉搜索树中右子树的结点均大于根结点
        for (int j = i; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        // 判断左子树是不是二叉树
        if (i > start) {
            if (!dfs(sequence, start, i - 1)) {
                return false;
            }
        }

        // 判断右子树是不是二叉树
        if (i < end) {
            if (!dfs(sequence, i, end - 1)) {
                return false;
            }
        }

        return true;
    }

}
