package leetcode.preparation.sort;

import leetcode.preparation.sort.adapter.*;
import leetcode.preparation.sort.adapter1.HeapSort1;
import leetcode.preparation.sort.adapter1.QuickSort1;

public class SortUtils {

    /**
     * 冒泡排序
     */
    public static int[] bubbleSort(int[] input) {
        return BubbleSort.sort(input);
    }

    /**
     * 选择排序
     */
    public static int[] selectionSort(int[] input) {
        return SelectionSort.sort(input);
    }

    /**
     * 插入排序
     */
    public static int[] insertionSort(int[] input) {
        return InsertionSort.sort(input);
    }

    /**
     * 归并排序
     */
    public static int[] mergeSort(int[] input) {
        return MergeSort.sort(input);
    }

    /**
     * 堆排序
     */
    public static int[] heapSort(int[] input) {
        return HeapSort1.sort(input);
    }

    /**
     * 快速排序
     */
    public static int[] quickSort(int[] input) {
        return QuickSort1.sort(input);
    }

    /**
     * 希尔排序
     */
    public static int[] shellSort(int[] input) {
        return ShellSort.sort(input);
    }

    /**
     * 基数排序
     */
    public static int[] radixSort(int[] input) {
        return RadixSort.sort(input);
    }

    /**
     * 计数排序
     */
    public static int[] countingSort(int[] input) {
        return CountingSort.sort(input);
    }

    /**
     * 桶排序
     */
    public static int[] bucketSort(int[] input) {
        return null;
    }

    /**
     * 二叉树排序
     */
    public static int[] treeSort(int[] input) {
        return null;
    }

    /**
     * 时间排序
     */
    public static int[] timeSort(int[] input) {
        return null;
    }

    /**
     * 立方体排序
     */
    public static int[] cubeSort(int[] input) {
        return null;
    }

}
