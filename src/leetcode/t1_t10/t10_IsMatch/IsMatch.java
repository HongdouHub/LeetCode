package leetcode.t1_t10.t10_IsMatch;

/**
 * 10. 正则表达式匹配
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 *
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 *     s 可能为空，且只包含从 a-z 的小写字母。
 *     p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class IsMatch {

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b*"));
        System.out.println(isMatch2("aab", "c*a*b*"));

        System.out.println(isMatch("", ".*"));
        System.out.println(isMatch2("", ".*"));
    }

    /**
     * 动态规划
     *
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     */
    private static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int sLen = s.length();
        int pLen = p.length();

        // 1. 状态定义：dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        // 2. 初始化状态
        dp[0][0] = true;
        for (int j = 0; j < pLen; j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }

        // 3. 思考状态转移方程
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {

                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {

                    dp[i + 1][j + 1] = dp[i][j];

                } else if (p.charAt(j) == '*') {

                    if (p.charAt(j - 1) != s.charAt(i)) {
                        dp[i +1][j + 1] = dp[i + 1][j - 1];
                    }

                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {

                        /**
                         *  dp[i + 1][j - 1] ： 指'*'充当去除前一个数据
                         *  dp[i + 1][j]     ： 指'*'充当s中最后一个数据（单个a）-a*
                         *  dp[i][j + 1]     ： 指'*'充当s中最后一个数据（多个a）-a*
                         */
                        dp[i + 1][j + 1] = dp[i + 1][j - 1] ||
                                            dp[i + 1][j] ||
                                            dp[i][j + 1];
                    }
                }
            }
        }

        return dp[sLen][pLen];
    }

    private static boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true; // here's y axis should be i+1
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                            /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             */

                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
