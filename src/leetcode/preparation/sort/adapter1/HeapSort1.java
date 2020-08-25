package leetcode.preparation.sort.adapter1;

public class HeapSort1 {

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

    private static void adjustHeap(int[] input, int i, int length) {

        int left = i * 2 + 1;
        int right = i * 2 + 2;

        int largestIndex = i;

        if (left < length && input[left] > input[largestIndex]) {
            largestIndex = left;
        }

        if (right < length && input[right] > input[largestIndex]) {
            largestIndex = right;
        }

        if (largestIndex != i) {
            swap(input, i , largestIndex);
            adjustHeap(input, largestIndex, length);
        }
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
