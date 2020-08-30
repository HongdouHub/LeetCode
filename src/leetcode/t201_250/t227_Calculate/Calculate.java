package leetcode.t201_250.t227_Calculate;

import java.util.List;
import java.util.Stack;

/**
 * 227. 基本计算器 II
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 */
@SuppressWarnings("all")
public class Calculate {

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2/(2/2)"));
    }

    private static int calculate(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return 0;
        }

        return calculate(s, new int[1]);
    }

    private static int calculate(String s, int[] i) {
        int length = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        int prev;

        for (; i[0] < length; i[0]++) {

            char c = s.charAt(i[0]);
            boolean isDigit = Character.isDigit(c);

            // 1. 先判断数字
            if (isDigit) {
                num = num * 10 + (c - '0');
            }

            // 2. 再判断小括号
            if (c == '(') {
                i[0]++;
                num = calculate(s, i);
            }

            // 3. 再判断操作符 + - * /
            if (!isDigit && c != ' ' || i[0] == length - 1) {
                switch (sign) {

                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        prev = stack.pop();
                        stack.push(prev * num);
                        break;
                    case '/':
                        prev = stack.pop();
                        stack.push(prev / num);
                        break;
                    default:
                }

                sign = c;
                num = 0;
            }

            // 4. 最后再判断小括号退出循环
            if (c == ')') {
                break;
            }
        }

        return sum(stack);
    }

    private static int sum(Stack<Integer> stack) {
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();

        }
        return result;
    }

}