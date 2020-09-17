package leetcode.t31_100.t76_MinWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * 给你一个字符串 S、一个字符串 T 。
 * 请你设计一种算法，可以在 O(n) 的时间复杂度内，
 * 从字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *      输入：S = "ADOBECODEBANC", T = "ABC"
 *      输出："BANC"
 *
 * 提示：
 *     如果 S 中不存这样的子串，则返回空字符串 ""。
 *     如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinWindow {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minWindow("ab", "b")); // b
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae")); // cwae
    }

    /**
     * 滑动窗口
     *
     * 时间复杂度：
     * 空间复杂度：
     */
    private static String minWindow(String s, String t) {
        int sLen;
        int tLen;

        if (s == null || (sLen = s.length()) == 0 ||
            t == null || (tLen = t.length()) == 0 ||
            sLen < tLen) {
            return "";
        }

        // 把子串的数据保存到 tMap 中，即(char, 出现的次数)
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int end = Integer.MAX_VALUE;
        int start = -1;

        int left = 0;
        int right = 0;
        Map<Character, Integer> windows = new HashMap<Character, Integer>();

        // 遍历，窗口往右滑，当窗口右边界的值==字符串长度时结束
        while (right < sLen) {
            // 增大窗口
            char cRight = s.charAt(right);
            if (tMap.containsKey(cRight)) {
                windows.put(cRight, windows.getOrDefault(cRight, 0) + 1);
            }
            right++;

            // 遍历，右边界右滑已经保证当前窗口已经包含子串，这次是左边界向左移，求最小窗口值
            while (right - left >= tLen && check(tMap, windows)) {
                if (end > right - left) {
//                    System.out.println("left: " + left + ", right: " + right);
                    start = left;
                    end = right - left;
                }

                // 缩小窗口
                char cLeft = s.charAt(left);

                // 如果包含左边界的值，当前窗口对应的键值对进行-1操作，然后求下一个满足要求的滑动窗口
                if (tMap.containsKey(cLeft)) {
                    windows.put(cLeft, windows.getOrDefault(cLeft, 0) - 1);
                }
                left++;
            }
        }

        return start == -1 ? "" : s.substring(start, start + end);
    }

    private static boolean check(Map<Character, Integer> tMap,
                                 Map<Character, Integer> windows) {

        for (Map.Entry<Character, Integer> next : tMap.entrySet()) {
            if (windows.getOrDefault(next.getKey(), 0) < next.getValue()) {
                return false;
            }
        }
        return true;
    }


}
