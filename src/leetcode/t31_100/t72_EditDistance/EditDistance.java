package leetcode.t31_100.t72_EditDistance;

import utils.TextUtils;

/**
 * word1 -> word2
 *
 * Insert、Delete、Replace
 *
 * 例如： horse -> ros
 *       intention -> nation
 */
public class EditDistance {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(solveByDynamicProgramming(word1, word2));
    }

    private static int solveByDynamicProgramming(String rawWords, String destWords) {
        if (TextUtils.isEmpty(rawWords)) {
            return TextUtils.isEmpty(destWords) ? 0 : destWords.length();
        }

        int rawSize = rawWords.length();
        int destSize = destWords.length();

        // word1 的前 i 个字符，变换到， word2 的前 j 个字符 最少步数
        int[][] dp = new int[rawSize + 1][destSize + 1];
        for (int i = 0; i < rawSize + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < destSize + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < rawSize + 1; i++) {
            for (int j = 1; j < destSize + 1; j++) {

                if (rawWords.charAt(i - 1) == destWords.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(
                            dp[i - 1][j], // Insert
                            dp[i][j - 1], // Delete
                            dp[i - 1][j - 1]  // Replace
                    );
                }
            }
        }
        return dp[rawSize][destSize];
    }

    private static int min(int... data) {
        int result = Integer.MAX_VALUE;
        if (data == null) return result;
        for (int d : data) {
            if (result > d) {
                result = d;
            }
        }
        return result;
    }
}
