package leetcode.preparation.sort.adapter;

/**
 * 希尔排序
 *
 * 最佳时间复杂度：O(n log(n))
 * 平均时间复杂度：O(n (log(n))^2)
 * 最差时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 *
 * 稳定性：不稳定
 * 复杂性：较复杂
 */
public class ShellSort {

    public static int[] sort(int[] input) {
        int length;
        if (input == null || (length = input.length) == 0) {
            return new int[0];
        }

        int gap = 1;
        int i;
        int j;
        int temp;

        while (gap < length / 3) {
            gap = gap * 3 + 1;
        }

        for (; gap > 0; gap /= 3) {
            for (i = gap; i < length; i++) {
                temp = input[i];
                for (j = i - gap; j >= 0 && input[j] > temp; j -= gap) {
                    input[j + gap] = input[j];
                }
                input[j + gap] = temp;
            }
        }
        return input;
    }
}
