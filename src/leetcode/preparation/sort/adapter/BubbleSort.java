package leetcode.preparation.sort.adapter;

/**
 * 冒泡排序
 *
 * 最佳时间复杂度：O(n)
 * 平均时间复杂度：O(n^2)
 * 最差时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 *
 * 稳定性：稳定
 */
public class BubbleSort {

    public static int[] sort(int[] input) {
        int length;
        if (input == null || (length = input.length) == 0) {
            return new int[0];
        }

        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (input[j] > input[j + 1]) {
                    temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        return input;
    }
}
