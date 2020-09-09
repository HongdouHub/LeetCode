package leetcode.t516_LongestPalindromeSubseq;

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
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));

    }

    private static int longestPalindromeSubseq(String s) {
        int len = s.length();

        if (len < 2) {
            return len;
        }

        char[] chars = s.toCharArray();

        // 1. 状态定义：dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];

        // 2. 初始化状态
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;

        // 3. 思考状态转移方程
//        dp[i][j] = (chars[i] == chars[j]) && j - i < 3 || dp[i + 1][j - 1];

        // 从目的点j= 1开始计算，长度小于len
        for (int j = 1; j < len; j++) {
            // 起始点i= 0，一定小于j
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else if (j - i < 3) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                }
            }
        }
        return maxLen;
    }
}
