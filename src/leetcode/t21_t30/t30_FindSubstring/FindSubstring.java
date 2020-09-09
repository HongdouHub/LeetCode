package leetcode.t21_t30.t30_FindSubstring;

import utils.GsonUtil;

import java.util.*;

/**
 * 30. 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。
 * 找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * 示例 1：
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 */
@SuppressWarnings("all")
public class FindSubstring {

    private static void print(List<Integer> list) {
        System.out.println(GsonUtil.array2Json(list));
    }

    public static void main(String[] args) {
        print(findSubstring1("barfoothefoobarman", new String[] {"foo","bar"}));
        print(findSubstring1("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));

        print(findSubstring2("barfoothefoobarman", new String[] {"foo","bar"}));
        print(findSubstring2("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));
    }

    private static List<Integer> findSubstring1(String s, String[] words) {
        int wordSize;
        int sLen;

        if (s == null || (sLen = s.length()) == 0 || words == null || (wordSize = words.length) == 0) {
            return new ArrayList<>();
        }

        int wordLen = words[0].length();
        int wordTotalLen = wordLen * wordSize;

        // 待查询单词Map
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (int i = 0; i < wordSize; i++) {
            wordCountMap.put(words[i], (wordCountMap.getOrDefault(words[i], 0)) + 1);
        }

        List<Integer> result = new ArrayList<>();
        // 遍历过程的Map
        Map<String, Integer> traversalCountMap = new HashMap<>();
        for (int i = 0; i < sLen - wordTotalLen + 1; i++) {
            int j;

            for (j = 0; j < wordTotalLen; j += wordLen) {
                String maybeWord = s.substring(i + j, i + j + wordLen);

                if (wordCountMap.containsKey(maybeWord) &&
                        wordCountMap.get(maybeWord) >= (traversalCountMap.getOrDefault(maybeWord, 0) + 1)) {
                    traversalCountMap.put(maybeWord, (traversalCountMap.getOrDefault(maybeWord, 0)) + 1);
                } else {
                    traversalCountMap.clear();
                    break;
                }
            }

            if (j >= wordTotalLen) {
                result.add(i);
            }
            traversalCountMap.clear();
        }
        return result;
    }

    private static List<Integer> findSubstring2(String s, String[] words) {
        int sLen;
        int wordSize;
        if (s == null || (sLen = s.length()) == 0 || words == null || (wordSize = words.length) == 0) {
            return new ArrayList<>();
        }

        int wordLen = words[0].length();
        int wordTotalLen = wordLen * wordSize;

        Map<String, Integer> wordCountMap = new HashMap<> ();
        for (int i = 0; i < wordSize; i++) {
            wordCountMap.put(words[i], wordCountMap.getOrDefault(words[i], 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        Map<String, Integer> traversalCountMap = new HashMap<> ();
        for (int i = 0; i < sLen - wordTotalLen + 1; i++) {
            String temp = s.substring(i, i + wordTotalLen);

            for (int j = 0; j < wordTotalLen; j += wordLen) {
                String maybeWord = temp.substring(j, j + wordLen);
                traversalCountMap.put(maybeWord, traversalCountMap.getOrDefault(maybeWord, 0) + 1);
            }

            if (wordCountMap.equals(traversalCountMap)) {
                result.add(i);
            }
            traversalCountMap.clear();
        }

        return result;
    }

}
