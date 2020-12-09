package leetcode.t151_200.t145_PostorderTraversal;

import leetcode.preparation.treenode.TreeNode;
import utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

import static leetcode.preparation.treenode.PrepareTreeNode.generate;

@SuppressWarnings("all")
public class PostorderTraversal {

    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(postorderTraversal(generate(1, null, 2, null, null, 3))));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private static void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        traversal(root.left, result);
        traversal(root.right, result);
        result.add(root.val);
    }

}
