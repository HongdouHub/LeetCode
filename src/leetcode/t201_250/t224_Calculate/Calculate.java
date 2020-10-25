package leetcode.t201_250.t224_Calculate;

import java.util.Stack;

/**
 * 224. 基本计算器
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 示例 1:
 * 输入: "1 + 1"
 * 输出: 2
 */
public class Calculate {

    public static void main(String[] args) {
        System.out.println(calculate1("1 + 1"));                // 2
        System.out.println(calculate2("1 + 1"));                // 2

        System.out.println(calculate1("(1+(4+5+2)-3)+(6+8)"));  // 23
        System.out.println(calculate2("(1+(4+5+2)-3)+(6+8)"));  // 23
    }

    /**
     * 方法一：栈和反转字符串
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    private static int calculate1(String s) {
        int operand = 0;
        int n = 0;
        Stack<Object> stack = new Stack<Object>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            // 纯数字，凑成 operand
            if (Character.isDigit(c)) {
                operand = (int) Math.pow(10, n) * (c - '0') + operand;
                n++;
            } else if (c != ' ') {

                if (n != 0) {
                    stack.push(operand);
                    n = 0;
                    operand = 0;
                }

                if (c == '(') {
                    int res = evaluateExpr(stack);
                    stack.pop();
                    stack.push(res);
                } else {
                    stack.push(c);
                }
            }
        }

        if (n != 0) {
            stack.push(operand);
        }

        return evaluateExpr(stack);
    }

    private static int evaluateExpr(Stack<Object> stack) {
        int result = 0;

        if (!stack.isEmpty()) {
            result = (int) stack.pop();
        }

        while (!stack.isEmpty() && ((char)stack.peek()) != ')') {

            char sign = (char) stack.pop();

            if (sign == '+') {
                result += (int) stack.pop();
            } else {
                result -= (int) stack.pop();
            }
        }

        return result;
    }

    /**
     * 通用解法
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    private static int calculate2(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return 0;
        }

        return calculate2(s, new int[1], length);
    }

    private static int calculate2(String s, int[] i, int length) {
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';

        for (; i[0] < length; i[0] += 1) {
            char c = s.charAt(i[0]);
            boolean isDigit = Character.isDigit(c);

            // 1. 先判断数字
            if (isDigit) {
                num = num * 10 + (c - '0');
            }

            // 2. 再判断小括号
            if (c == '(') {
                i[0] += 1;
                num = calculate2(s, i, length);
            }

            // 3. 再判断操作符 + -
            // 最后一次，数据只是存在num中，没有存入stack，故仍然让其进入该判断
            if (!isDigit && c != ' ' || i[0] == length - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
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
