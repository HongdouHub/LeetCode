package leetcode.preparation.sort.adapter;

/**
 * 归并排序
 *
 * 最佳时间复杂度：O(n log(n))
 * 平均时间复杂度：O(n log(n))
 * 最差时间复杂度：O(n log(n))
 * 空间复杂度：O(n)
 *
 * 稳定性：稳定
 */
public class MergeSort {

    public static int[] sort(int[] input) {
        int length;
        if (input == null || (length = input.length) == 0) {
            return new int[0];
        }

        int[] temp = new int[length];
        mergeSort(input, temp, 0, 0, length - 1);
        return input;
    }

    private static void mergeSort(int[] input, int[] output, int i, int start, int end) {
        if (start == end) {
            if ((i & 1) == 1) {
                output[start] = input[start];
            }
        } else {
            int middle = (start + end) >> 1;

            mergeSort(input, output, i + 1, start, middle);
            mergeSort(input, output, i + 1, middle + 1, end);

            if ((i & 1) == 1) {
                merge(input, output, start, middle, end);
            } else {
                merge(output, input, start, middle, end);
            }
        }
    }

    /**
     * 数据从input 排序后 拷贝到 output
     */
    private static void merge(int[] input, int[] output, int start, int middle, int end) {
        int index, j;

        for (index = start, j = middle + 1; start <= middle && j <= end ;) {
            output[index++] = input[start] <= input[j] ? input[start++] : input[j++];
        }

        while (start <= middle) {
            output[index++] = input[start++];
        }

        while (j <= end) {
            output[index++] = input[j++];
        }
    }
}