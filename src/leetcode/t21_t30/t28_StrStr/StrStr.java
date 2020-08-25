package leetcode.t21_t30.t28_StrStr;

/**
 * 28. 实现 strStr()
 *
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr1("hello", "ll"));
        System.out.println(strStr1("aaaaa", "bba"));
        System.out.println(strStr1("a", "a"));
        System.out.println(strStr1("mississippi", "mississippi"));
    }

    /**
     * 暴力匹配算法
     *
     * 时间复杂度 O(MN)
     * 空间复杂度 O(1)
     */
    private static int strStr1(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();

        if (m == 0 && n == 0) {
            return 0;
        }

        for (int i = 0; i <= n - m; i++) {
            int j;

            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                return i;
            }
        }
        return -1;
    }

}
