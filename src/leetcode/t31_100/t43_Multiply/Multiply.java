package leetcode.t31_100.t43_Multiply;


import leetcode.preparation.MethodBuilder;
import utils.TextUtils;

/**
 * 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
@SuppressWarnings("all")
public class Multiply {

    public static void main(String[] args) {
        test("multiply0");
        test("multiply1");

    }

    private static void test(String methodName) {
        MethodBuilder build = new MethodBuilder.Builder()
                .setClazz(Multiply.class)
                .setMethodName(methodName)
                .setParameterTypes(new Class[]{String.class, String.class})
                .build();

        System.out.println(build.invoke("2", "5"));
        System.out.println(build.invoke("123", "456"));
        System.out.println(build.invoke("498828660196", "840477629533"));
    }

    /**
     * 利用系统的乘法规则
     * @deprecated 已废弃，原因是：结果超出Long最大值时，结果出错。
     */
    private static String multiply0(String num1, String num2) {
        int len1, len2;
        if (num1 == null || (len1 = num1.length()) == 0 ||
                num2 == null || (len2 = num2.length()) == 0) {
            return null;
        }

        if (TextUtils.equals("0", num1) || TextUtils.equals("0", num2)) {
            return "0";
        }

        long number1 = 0;
        long number2 = 0;

        for (int i = 0; i < len1; i++) {
            char c = num1.charAt(i);

            number1 = 10 * number1 + (c - '0');
        }

        for (int i = 0; i < len2; i++) {
            char c = num2.charAt(i);

            number2 = 10 * number2 + (c - '0');
        }

        return String.valueOf(number1 * number2);
    }

    /**
     * 优化竖式
     *
     * 时间复杂度：O(MN)   M,N 分别为 num1 和 num2 的长度。
     * 空间复杂度：O(M+N)  用于存储计算结果。
     */
    private static String multiply1(String num1, String num2) {
        int len1, len2;
        if (num1 == null || (len1 = num1.length()) == 0 ||
                num2 == null || (len2 = num2.length()) == 0) {
            return null;
        }

        if (TextUtils.equals("0", num1) || TextUtils.equals("0", num2)) {
            return "0";
        }

        int[] result = new int[len1 + len2];
        int bit1, bit2;

        for (int i = len1 - 1; i >= 0; i--) {
            bit1 = num1.charAt(i) - '0';

            for (int j = len2 - 1; j >= 0; j--) {
                bit2 = num2.charAt(j) - '0';

                int sum = result[i + j + 1] + bit1 * bit2;
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len1 + len2; i++) {
            if (i == 0 && result[i] == 0) {
                continue;
            }
            builder.append(result[i]);
        }
        return builder.toString();
    }
}
