package leetcode.preparation.sort.adapter;

/**
 * 计数排序
 * <p>
 * 每个桶只存储单一键值；
 *
 * 最佳时间复杂度：O(n+k)
 * 平均时间复杂度：O(n+k)
 * 最差时间复杂度：O(n+k)
 * 空间复杂度：O(k)
 *
 * 稳定性：稳定
 */
public class CountingSort {

    // 假设 input数组 中的数据a'有，0<=a' && a' < k 并且k=100
    private static int DEFAULT_MAX_MATCHER = 100;

    public static int[] sort(int[] input) {
        int length;
        if (input == null || (length = input.length) == 0) {
            return new int[0];
        }

        int[] output = new int[length];
        countingSort(input, output, DEFAULT_MAX_MATCHER);
        return output;
    }

    private static void countingSort(int[] input, int[] output, int k) {
        int[] temp = new int[k];
        int length = input.length;

        // 计数
        for (int i = 0; i < length; i++) {
            int a = input[i];
            temp[a] += 1;
        }

        // 求计数和
        for (int i = 1; i < k; i++) {
            temp[i] = temp[i] + temp[i - 1];
        }

        // 整理
        for (int i = length - 1; i >= 0; i--) {
            int a = input[i];
            output[temp[a] - 1] = a;
            temp[a] -= 1;
        }
    }
}
