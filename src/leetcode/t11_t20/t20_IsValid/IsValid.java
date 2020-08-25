package leetcode.t11_t20.t20_IsValid;

import java.util.ArrayList;
import java.util.List;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("{[]}"));
    }

    private static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                charList.add(c);
            } else if (c == ')') {
                if (charList.isEmpty() || charList.remove(charList.size() - 1) != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (charList.isEmpty() || charList.remove(charList.size() - 1) != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (charList.isEmpty() || charList.remove(charList.size() - 1) != '{') {
                    return false;
                }
            }
        }
        return charList.isEmpty();
    }

}
