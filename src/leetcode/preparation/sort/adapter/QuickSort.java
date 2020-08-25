package leetcode.preparation.sort.adapter;

/**
 * 快速排序
 *
 * 最佳时间复杂度：O(n log(n))
 * 平均时间复杂度：O(n log(n))
 * 最差时间复杂度：O(n^2)
 * 空间复杂度：O(log(n))
 *
 * 稳定性：不稳定
 */
public class QuickSort {

    public static int[] sort(int[] input) {
        int length;
        if (input == null || (length = input.length) == 0) {
            return new int[0];
        }

        return quickSort1(input, 0, length - 1);
    }

    private static int[] quickSort1(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {
            // 从右边遍历，找到第一个小于 pivot 的下标
            while ((i < j) && (input[j] > pivot)) {
                j--;
            }

            // 从左边遍历，找到第一个大于 pivot 的下标
            while ((i < j) && (input[i] < pivot)) {
                i++;
            }

            if ((input[i] == input[j]) && (i < j)) {
                i++;
            } else if (i != j) {
                swap(input, i, j);
            }
        }

        if (i - 1 > start) {
            quickSort1(input, start, i - 1);
        }
        if (j + 1 < end) {
            quickSort1(input, j + 1, end);
        }
        return input;
    }

    private static int[] quickSort2(int[] input, int start, int end) {
        if (start >= end) {
            return input;
        }

        int left = start;
        int right = end - 1;

        while (left < right) {

            while (input[left] <= input[end] && left < right) {
                left++;
            }

            while (input[right] >= input[end] && left < right) {
                right--;
            }

            swap(input, left, right);
        }

        if (input[left] >= input[end]) {
            swap(input, left, end);
        } else {
            left++;
        }

        quickSort2(input, start, left - 1);
        quickSort2(input, left + 1, end);
        return input;
    }

    private <T extends Comparable<? super T>> void quickSort3(T[] targetArr, int start, int end) {
        int i = start, j = end;
        T key = targetArr[start];

        while (i < j) {
            /*按j--方向遍历目标数组，直到比key小的值为止*/
            while (j > i && targetArr[j].compareTo(key) >= 0) {
                j--;
            }
            if (i < j) {
                /*targetArr[i]已经保存在key中，可将后面的数填入*/
                targetArr[i] = targetArr[j];
                i++;
            }
            /*按i++方向遍历目标数组，直到比key大的值为止*/
            while (i < j && targetArr[i].compareTo(key) <= 0)
                /*此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，那么这个小于等于的作用就会使下面的if语句少执行一亿次。*/ {
                i++;
            }
            if (i < j) {
                /*targetArr[j]已保存在targetArr[i]中，可将前面的值填入*/
                targetArr[j] = targetArr[i];
                j--;
            }
        }
        /*此时i==j*/
        targetArr[i] = key;//应加判断

        /*递归调用，把key前面的完成排序*/
        quickSort3(targetArr, start, i - 1);


        /*递归调用，把key后面的完成排序*/
        quickSort3(targetArr, j + 1, end);
        //两个递归应加判断
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
