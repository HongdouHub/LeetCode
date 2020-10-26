package leetcode.t451_650.t516_LongestPalindromeSubseq;

/**
 * 516. 最长回文子序列
 *
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。
 * 可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 *      输入: "bbbab"
 *      输出: 4
 *      一个可能的最长回文子序列为 "bbbb"
 *
 * 示例 2:
 *      输入: "cbbd"
 *      输出: 2
 *      一个可能的最长回文子序列为 "bb"
 */
@SuppressWarnings("all")
public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab")); // 4(bbbb)
        System.out.println(longestPalindromeSubseq("cbbd"));  // 2(bb)
        System.out.println(longestPalindromeSubseq("aabaa")); // 5(aabaa)

    }

    /**
     * 动态规划
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     */
    private static int longestPalindromeSubseq(String s) {
        int length = s.length();

        if (length < 2) {
            return length;
        }

        char[] chars = s.toCharArray();

        // 1. 状态定义：dp[i][j] 表示 s[i, j] 中最长回文子序列的长度
        int[][] dp = new int[length][length];

        // 2. 初始化状态
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        // 3. 思考状态转移方程
//        dp[i][j] = (chars[i] == chars[j]) ?
//                dp[i + 1][j - 1] + 2 :
//                Math.max(dp[i + 1][j], dp[i][j - 1]);

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = (chars[i] == chars[j]) ?
                        dp[i + 1][j - 1] + 2 :
                        Math.max(dp[i + 1][j], dp[i][j - 1]);

//                PrepareArray.print(dp);
            }
        }
//        PrepareArray.print(dp);
        return dp[0][length - 1];
    }
}
