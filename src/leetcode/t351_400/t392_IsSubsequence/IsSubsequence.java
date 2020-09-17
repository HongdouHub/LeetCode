package leetcode.t351_400.t392_IsSubsequence;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。
 * 字符串 t 可能会很长（长度 ~= 500,000），
 * 而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc" 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc" 返回 false.
 */
@SuppressWarnings("all")
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence1("abc", "ahbgdc"));
        System.out.println(isSubsequence1("axc", "ahbgdc"));
    }

    /**
     * 方法一：双指针
     *
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(1)
     */
    private static boolean isSubsequence1(String s, String t) {
        int start1 = 0, end1;
        int start2 = 0, end2;

        if (s == null || t == null) {
            return false;
        }

        end1 = s.length();
        end2 = t.length();

        if (end1 == 0 && end2 == 0) {
            return true;
        }

        while (start1 < end1 && start2 < end2) {
            if (s.charAt(start1) == t.charAt(start2)) {
                start1++;
            }
            start2++;
        }

        return start1 == end1;
    }

}
