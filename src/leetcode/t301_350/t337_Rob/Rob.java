package leetcode.t301_350.t337_Rob;

import leetcode.preparation.treenode.TreeNode;

import static leetcode.preparation.treenode.PrepareTreeNode.generate;

/**
 * 337. 打家劫舍 III
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class Rob {

    public static void main(String[] args) {
        System.out.println(rob(generate(new Integer[]{3, 2, 3, null, 3, null, 1})));    // 7
        System.out.println(rob(generate(new Integer[]{3, 4, 5, 1, 3, null, 1})));       // 9
    }

    /**
     * DFS
     *
     * 时间复杂度： O(N)
     * 空间复杂度： O(N)
     */
    private static int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 返回一个大小为 2 的数组 arr
     *
     * arr[0] 表示不抢 root 的话，得到的最大钱数
     * arr[1] 表示抢 root 的话，得到的最大钱数
     */
    private static int[] dp(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }

        int[] left = dp(root.left);
        int[] right = dp(root.right);

        // 不抢，下家可抢可不抢，取决于收益大小
        int noRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // 抢，下家就不能抢了
        int rob = root.val + left[0] + right[0];

        return new int[] {noRob, rob};
    }

}
