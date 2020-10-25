package leetcode.t451_650.t567_CheckInClusion;

import leetcode.preparation.MethodBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class CheckInclusion {

    public static void main(String[] args) {
        test("checkInclusion1");
        test("checkInclusion2");
        test("checkInclusion3");
    }

    private static void test(String methodName) {
        MethodBuilder build = new MethodBuilder.Builder()
                .setClazz(CheckInclusion.class)
                .setMethodName(methodName)
                .setParameterTypes(new Class[]{String.class, String.class})
                .build();

        System.out.println(String.format("-------------%s------------", methodName));
        System.out.println(build.invoke("ab", "eidbaooo")); // True
        System.out.println(build.invoke("ab", "eidboaoo")); // False
        System.out.println(build.invoke("hello", "ooolleoooleh"));  // False
        System.out.println("----------------------------------------\n");
    }

    /**
     * 哈希表法 - 超时
     *
     * 时间复杂度：O(l1+26∗l1∗(l2−l1))。
     *      这个哈希表包含最多26个键。
     *      其中 l1​ 是字符串 l1​的长度，l2 是字符串 l2 的长度。
     *
     *
     * 空间复杂度：O(1)。
     *      表包含最多 26 个键值对。
     */
    private static boolean checkInclusion1(String s1, String s2) {
        int len1;
        int len2;

        if (s1 == null || (len1 = s1.length()) == 0 ||
            s2 == null || (len2 = s2.length()) == 0) {
            return false;
        }

        Map<Integer, Integer> keyMap = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            int c = s1.charAt(i) - 'a';
            keyMap.put(c, keyMap.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> traversalMap = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            int j = i;
            for (; j < i + len1; j++) {
                if (j >= len2) {
                    return false;
                }

                int c = s2.charAt(j) - 'a';

                if (!keyMap.containsKey(c)) {
                    traversalMap.clear();
                    i = j;
                    break;
                }

                if (keyMap.get(c) >= traversalMap.getOrDefault(c, 0) + 1) {
                    traversalMap.put(c, traversalMap.getOrDefault(c, 0) + 1);
                } else {
                    traversalMap.clear();
                    break;
                }
            }

            if (j == (i + len1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数组法 - 通过
     *
     * 时间复杂度：O(l1+26∗l1∗(l2−l1))。
     *      这个数组包含最多26个键。
     *      其中 l1​ 是字符串 l1​的长度，l2 是字符串 l2 的长度。
     *
     *
     * 空间复杂度：O(1)。
     *      表包含最多 26 个键值对。
     */
    private static boolean checkInclusion2(String s1, String s2) {
        int len1;
        int len2;

        if (s1 == null || (len1 = s1.length()) == 0 ||
                s2 == null || (len2 = s2.length()) == 0) {
            return false;
        }

        int[] keyArray = new int[26];
        for (int i = 0; i < len1; i++) {
            int c = s1.charAt(i) - 'a';
            keyArray[c]++;
        }

        int[] traversalArray = new int[26];
        for (int i = 0; i < len2; i++) {
            int j = i;
            for (; j < i + len1; j++) {
                if (j >= len2) {
                    return false;
                }

                int c = s2.charAt(j) - 'a';

                if (keyArray[c] == 0) {
                    Arrays.fill(traversalArray, 0);
                    i = j;
                    break;
                }

                if (keyArray[c] >= traversalArray[c] + 1) {
                    traversalArray[c]++;
                } else {
                    Arrays.fill(traversalArray, 0);
                    break;
                }
            }

            if (j == (i + len1)) {
                return true;
            }
        }
        return false;
    }
}
