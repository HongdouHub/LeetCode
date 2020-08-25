package leetcode.preparation.sort.adapter;

/**
 * 堆排序（选择排序）
 *
 * 最佳时间复杂度：O(n log(n))
 * 平均时间复杂度：O(n log(n))
 * 最差时间复杂度：O(n log(n))
 * 空间复杂度：O(1)
 *
 * 稳定性：不稳定
 */
public class HeapSort {

    public static int[] sort(int[] input) {
        int length;
        if (input == null || (length = input.length) == 0) {
            return new int[0];
        }

        // 1. 构建大顶堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap(input, i, length);
        }

        // 2. 调整堆结构：交换堆顶元素与末尾元素
        for (int i = length - 1; i > 0; i--) {
            swap(input, 0, i);
            length--;
            adjustHeap(input, 0, length);
        }
        return input;
    }

    private static void adjustHeap(int[] input, int index, int length) {

        // 先根据堆性质，找出它左右节点的索引
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // 默认当前节点（父节点）是最大值。
        int largestIndex = index;

        // 如果有左节点，并且左节点的值更大，更新最大值的索引
        if (left < length && input[left] > input[largestIndex]) {
            largestIndex = left;
        }

        // 如果有右节点，并且右节点的值更大，更新最大值的索引
        if (right < length && input[right] > input[largestIndex]) {
            largestIndex = right;
        }

        if (largestIndex != index) {
            // 如果最大值不是当前非叶子节点的值，那么就把当前节点和最大值的子节点值互换
            swap(input, index, largestIndex);

            // 因为互换之后，子节点的值变了，如果该子节点也有自己的子节点，仍需要再次调整。
            adjustHeap(input, largestIndex, length);
        }
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
