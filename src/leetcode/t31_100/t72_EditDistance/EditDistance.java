package leetcode.t31_100.t72_EditDistance;

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
        System.out.println(minDistance(null, "ros"));
        System.out.println(minDistance("", "ros"));
        System.out.println(minDistance("horse", null));
        System.out.println(minDistance("horse", ""));
        System.out.println(minDistance("horse", "ros"));
    }

    /**
     * 动态规划
     *
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     */
    private static int minDistance(String word1, String word2) {
        int wordLen1;
        int wordLen2;

        if (word1 == null || (wordLen1 = word1.length()) == 0) {
            return (word2 == null) ? 0 : word2.length();
        }

        if (word2 == null || (wordLen2 = word2.length()) == 0) {
            return word1.length();
        }

        // 1. 状态定义： dp[i][j] 表示 word1的前i个字符， 变换到 word2的前j个字符，花费的最少步数
        int[][] dp = new int[wordLen1 + 1][wordLen2 + 1];

        // 2. 初始化状态
        for (int i = 0; i <= wordLen1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= wordLen2; j++) {
            dp[0][j] = j;
        }

        // 3. 思考状态转移方程
        for (int i = 1; i <= wordLen1; i++) {
            for (int j = 1; j <= wordLen2; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(
                            dp[i - 1][j],   // 插入一个字符
                            dp[i][j - 1],   // 删除一个字符
                            dp[i - 1][j -1] // 替换一个字符
                    );
                }
            }
        }
        return dp[wordLen1][wordLen2];
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
