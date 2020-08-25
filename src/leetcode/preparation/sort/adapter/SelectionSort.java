package leetcode.preparation.sort.adapter;

/**
 * 简单选择排序（选择排序）
 *
 * 最佳时间复杂度：O(n log(n))
 * 平均时间复杂度：O(n (log(n))^2)
 * 最差时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 *
 * 稳定性：稳定
 * 复杂性：较复杂
 */
public class SelectionSort {

    public static int[] sort(int[] input) {
        int length;
        if (input == null || (length = input.length) == 0) {
            return new int[0];
        }

        int index, temp;
        for (int i = 0; i < length; i++) {
            index = i;

            for (int j = i + 1; j < length; j++) {
                if (input[index] > input[j]) {
                    index = j;
                }
            }

            temp = input[index];
            input[index] = input[i];
            input[i] = temp;
        }

        return input;
    }
}