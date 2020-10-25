package leetcode.t401_450.t438_FindAnagrams;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 * 示例 1:
 *      输入: s: "cbaebabacd" p: "abc"
 *      输出: [0, 6]
 *      解释:
 *          起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 *          起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 示例 2:
 *      输入: s: "abab" p: "ab"
 *      输出: [0, 1, 2]
 *      解释:
 *          起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 *          起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 *          起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
@SuppressWarnings("all")
public class FindAnagrams {

    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(findAnagrams("cbaebabacd", "abc")));
    }

    private static List<Integer> findAnagrams(String s, String p) {
        int sLen, pLen;
        if (s == null || (sLen = s.length()) == 0 ||
                p == null || (pLen = p.length()) == 0) {
            return new ArrayList<>();
        }

        // 定义一个 needs 数组来看 p 中包含元素的个数
        int[] needs = new int[26];
        for (int i = 0; i < pLen; i++) {
            needs[p.charAt(i) - 'a'] += 1;
        }

        List<Integer> result = new ArrayList<>();

        int left = 0, right = 0;
        // 定义一个 window 数组来看滑动窗口中是否有 p 中的元素，并记录出现的个数
        int[] window = new int[26];

        while (right < sLen) {
            int sRight = s.charAt(right) - 'a';
            // 1. 增大窗口
            right++;

            // 2. 进行窗口内数据的一系列更新
            window[sRight]++;

            while (window[sRight] > needs[sRight]) {
                int sLeft = s.charAt(left) - 'a';
                // 3. 缩小窗口
                left++;

                // 4. 进行窗口内数据的一系列更新
                window[sLeft]--;
            }

            if (right - left == pLen) {
                result.add(left);
            }
        }
        return result;
    }

}
