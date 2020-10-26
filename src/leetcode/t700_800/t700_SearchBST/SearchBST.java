package leetcode.t700_800.t700_SearchBST;

import leetcode.preparation.treenode.TreeNode;

import static leetcode.preparation.treenode.PrepareTreeNode.generate;
import static leetcode.preparation.treenode.PrepareTreeNode.print;

/**
 * 700. 二叉搜索树中的搜索
 *
 * 给定二叉搜索树（BST）的根节点和一个值。
 * 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。
 * 如果节点不存在，则返回 NULL。
 */
@SuppressWarnings("all")
public class SearchBST {

    public static void main(String[] args) {
        print(searchBST(generate(4, 2, 7, 1, 3), 2));
    }

    private static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

}
