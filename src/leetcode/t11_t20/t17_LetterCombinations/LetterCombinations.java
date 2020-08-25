package leetcode.t11_t20.t17_LetterCombinations;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
@SuppressWarnings("all")
public class LetterCombinations {
    private static final String[] LETTER_MAP = new String[] {
            "", "*", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(letterCombinations1("23")));
        System.out.println(GsonUtil.array2Json(letterCombinations2("23")));
    }

    /**
     * 队列
     */
    private static List<String> letterCombinations1(String digits) {
        int length;
        if(digits==null || (length = digits.length())==0) {
            return new ArrayList<String>();
        }

        List<String> res = new ArrayList<>();
        res.add("");

        for (int i = 0; i < length; i++) {
            String letters = LETTER_MAP[digits.charAt(i) - '0'];

            int size = res.size();
            for (int j = 0; j < size; j++) {
                String remove = res.remove(0);

                for (int k = 0; k < letters.length(); k++) {
                    res.add(remove + letters.charAt(k));
                }
            }
        }
        return res;
    }

    /**
     * 回溯
     */
    private static List<String> letterCombinations2(String digits) {
        int length;
        if(digits==null || (length = digits.length())==0) {
            return new ArrayList<String>();
        }

        List<String> res = new ArrayList<>();
        iterStr(digits, res, "", 0, length);
        return res;
    }

    private static void iterStr(String digits, List<String> res, String letter, int index, int length) {
        if (index == length) {
            res.add(letter);
            return;
        }

        int pos = digits.charAt(index) - '0'; // 0-9
        String letters = LETTER_MAP[pos];     // 字母组

        for (int i = 0; i < letters.length(); i++) {
            iterStr(digits, res, letter + letters.charAt(i), index + 1, length);
        }
    }
}
