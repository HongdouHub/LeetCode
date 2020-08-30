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

    /**
     * 通过从0 开始的下标获取对应的节点
     */
    public TreeNode get(int index) {

        int depth;
        int levelIndex = 0;

        for (depth = 0; depth < 30; depth++) {
            int level = (int) (Math.pow(2, depth) - 1);
            int nextLevel = (int) (Math.pow(2, depth + 1) - 1);

            if (level <= index + 1 && index + 1 <= nextLevel) {
                levelIndex = index - level;
                break;
            }
        }

        TreeNode root = this;
        int left = 0;
        int right = (int) (Math.pow(2, depth) - 1);
        int middle;

        for (int i = 0; i < depth; i++) {
            middle = (left + right) >> 1;

            if (levelIndex <= middle) {
                // 查找的下标 <= 遍历过程的下标 （往左靠）

                right = middle;
                root = root.left;
            } else {
                // 查找的下标 > 遍历过程的下标  （往右靠）

                left = middle + 1;
                root = root.right;
            }
        }
        return root;
    }
}
