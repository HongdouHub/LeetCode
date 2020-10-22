package leetcode.t1_t10.t5_LongestPalindrome;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        test("babad");      // bab
        test("cbbd");       // bb
        test("cbefebd");    // befeb
    }

    private static void test(String s) {
        System.out.println(longestPalindrome1(s));
        System.out.println(longestPalindrome2(s));
        System.out.println("-----------------\n");
    }

    /**
     * 方法一：暴力匹配 （Brute Force）
     *
     * 时间复杂度：O(N^3)，这里 N 是字符串的长度，枚举字符串的左边界、右边界，
     * 然后继续验证子串是否是回文子串，这三种操作都与 N 相关；
     *
     * 空间复杂度：O(1)，只使用到常数个临时变量，与字符串长度无关。
     */
    private static String longestPalindrome1(String s) {
        int len = s.length();

        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 暴力法采用双指针两边夹，验证是否是回文子串。
     */
    private static boolean validPalindromic(char[] charArray, int i, int j) {
        while (i < j) {
//            System.out.println(String.format("比较: charArray[%d] = %c, charArray[%d] = %c", i, charArray[i], j, charArray[j]));
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 方法二：动态规划 - 降维
     *
     * 时间复杂度：O(N^{2})
     *
     * 空间复杂度：O(N^{2})，二维 dp 问题，
     * 一个状态得用二维有序数对表示，因此空间复杂度是 O(N^{2})。
     */
    private static String longestPalindrome2(String s) {
        int len = s.length();

        if (len < 2) {
            return s;
        }

        char[] chars = s.toCharArray();

        // 1. 状态定义：dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];

        // 2. 初始化状态
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;

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
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
