package leetcode.t1143_LongestCommonSubsequence;

/**
 * 1143. 最长公共子序列
 * <p>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 */
@SuppressWarnings("all")
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc", "ac"));      // 2
        System.out.println(longestCommonSubsequence("abcde", "ace"));   // 3
        System.out.println(longestCommonSubsequence("abc", "abc"));     // 3
        System.out.println(longestCommonSubsequence("abc", "def"));     // 0
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        int len1;
        int len2;

        if (text1 == null || (len1 = text1.length()) == 0 ||
                text2 == null || (len2 = text2.length()) == 0) {
            return 0;
        }

        // 1. 状态定义：dp[i][j] 表示 s[i, j] 的最长公共子序列长度
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 2. 初始化状态

        // 3. 思考状态转移方程
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {

                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
//                PrepareArray.print(dp);
            }
        }

        return dp[len1][len2];
    }

}
