package leetcode.t1_t10.t3_LengthOfLongestSubstring;

import java.util.LinkedHashMap;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
    }

    private static int lengthOfLongestSubstring(String s) {
        int size;
        if (s == null || (size = s.length()) == 0) {
            return 0;
        }

        int maxValue = 0;
        int leftIndex = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        Character c;
        for (int i = 0; i < size; i++) {
            c = s.charAt(i);
            if (map.containsKey(c)) {
                leftIndex = Math.max(leftIndex, map.get(c) + 1);
            }
            map.put(c, i);
            maxValue = Math.max(maxValue, i - leftIndex + 1);
        }
        return maxValue;
    }
}
