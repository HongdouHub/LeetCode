package leetcode.t11_t20.t14_LongestCommonPrefix;

/**
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *      输入: ["flower","flow","flight"]
 *      输出: "fl"
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // fl
    }

    private static String longestCommonPrefix(String[] strs) {
        int length;
        if (strs == null || (length = strs.length) == 0) {
            return "";
        }

        String ans = strs[0];
        if (ans == null || ans.length() == 0) {
            return "";
        }


        for (int i = 0; i < length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }

            ans = ans.substring(0, j);

            if (j == 0) {
                return "";
            }
        }
        return ans;
    }

}
