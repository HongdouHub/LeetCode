package leetcode.preparation.treenode;

import utils.TextUtils;

public class TreeNode {

    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }

    @Override
    public int hashCode() {
        return val == null ? 0 : val.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TreeNode)) {
            return false;
        }
        TreeNode node = (TreeNode) obj;
        return TextUtils.equals(String.valueOf(node.val), String.valueOf(this.val));
    }
}
