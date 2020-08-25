package leetcode.t21_t30.class_t22_GenerateParentheses;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 */
public class GenerateParentheses {

    /**
     * 传入 n 计算出 n 组括号对应的不同合法组合
     *
     * 组合大小： 2 * n
     * 每个位置均有 ( 或 ) 选择，对应有 2 ^ 2n 的可能性：
     *   校验合法时，有如下改进：—— O(2^n)
     *      1、 局部不合法，不再递归
     *      2、左括号只能有 n 个，右括号也只能有 n 个
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        generate1(list, 0, 0, 3, "");
        System.out.println(GsonUtil.array2Json(list));

        list = new ArrayList<>();
        generate2(list, "", 3, 3);
        System.out.println(GsonUtil.array2Json(list));
    }

    private static void generate1(List<String> list, int leftUsed,
                                  int rightUsed, int n, String result) {
        if (leftUsed == n && rightUsed == n) {
            list.add(result);
            return;
        }

        if (leftUsed < n) {
            generate1(list, leftUsed + 1, rightUsed, n, result + "(");
        }

        if (leftUsed > rightUsed && rightUsed < n) {
            generate1(list, leftUsed, rightUsed + 1, n, result + ")");
        }
    }

    private static void generate2(List<String> list, String sublist, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(sublist);
            return;
        }

        if (left > 0) {
            generate2(list, sublist + "(", left -1, right);
        }

        if (right > left) {
            generate2(list, sublist + ")", left, right - 1);
        }
    }
}
