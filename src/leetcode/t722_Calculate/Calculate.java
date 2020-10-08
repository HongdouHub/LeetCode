package leetcode.t722_Calculate;

import java.util.Stack;

/**
 * 227. 基本计算器 III
 *
 * 实现一个基本的计算器来计算一个简单的表达式字符串。
 * 表达式字符串可以包含开括号（和右括号），加号+或减号-，非负整数和空格。
 * 表达式字符串仅包含非负整数，+，-，*，/运算符，左（和右括号）和空格。整数除法应截断为零。
 * 您可以假设给定的表达式始终有效。所有中间结果将在[-2147483648，2147483647]范围内。
 *
 */
public class Calculate {

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));                     // 2
        System.out.println(calculate(" 6-4 / 2 "));                 // 4
        System.out.println(calculate("2*(5+5*2)/3+(6/2+8)"));       // 21
        System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));// -12
    }

    private static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return calculate(s, new int[1]);
    }

    private static int calculate(String s, int[] index) {
        int length = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for (; index[0] < length; index[0] += 1) {
            char c = s.charAt(index[0]);
            boolean isDigit = Character.isDigit(c);

            if (isDigit) {
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                index[0] += 1;
                num = calculate(s, index);
            }

            if (!isDigit && c != ' ' || index[0] == length - 1) {
                switch (sign) {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                }

                sign = c;
                num = 0;
            }

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
