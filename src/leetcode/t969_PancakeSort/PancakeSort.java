package leetcode.t969_PancakeSort;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static utils.ConsoleUtils.println;

/**
 * 969. 煎饼排序
 * 给定数组 A，我们可以对其进行煎饼翻转：
 * 我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。
 * 我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 *
 * 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。
 * 任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
 *
 * 示例 1：
 *      输入：[3,2,4,1]
 *      输出：[4,2,4,3]
 *      解释：
 *          我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 *          初始状态 A = [3, 2, 4, 1]
 *          第一次翻转后 (k=4): A = [1, 4, 2, 3]
 *          第二次翻转后 (k=2): A = [4, 1, 2, 3]
 *          第三次翻转后 (k=4): A = [3, 2, 1, 4]
 *          第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
 *
 * 示例 2：
 *      输入：[1,2,3]
 *      输出：[]
 *      解释：
 *          输入已经排序，因此不需要翻转任何内容。
 *          请注意，其他可能的答案，如[3，3]，也将被接受。
 */
public class PancakeSort {

    public static void main(String[] args) {
        System.out.println(GsonUtil.array2Json(pancakeSort(new int[] {3, 2, 4, 1})));   // [4,2,4,3]
        System.out.println(GsonUtil.array2Json(pancakeSort(new int[] {1, 2, 3})));      // []
    }

    private static List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();

        int index = arr.length - 1;

        while (index >= 0) {
            int maxIndex = findMaxIndex(arr, index);

            // 通过 pancake 进行两次煎饼翻转，将最大值放到数组末尾
            if (maxIndex != index) {
                println(String.format("\nmax：%s, maxIndex：%s", arr[maxIndex], maxIndex));
                println(String.format("原始：%s", GsonUtil.array2Json(Arrays.asList(arr))));

                result.add(maxIndex + 1);
                pancake(arr, maxIndex);
                println(String.format("煎饼：%s", GsonUtil.array2Json(Arrays.asList(arr))));

                result.add(index + 1);
                pancake(arr, index);
                println(String.format("煎饼：%s", GsonUtil.array2Json(Arrays.asList(arr))));
            }

            index--;
        }

        result.removeIf(next -> next == 0 || next == 1);

        return result;
    }

    private static void pancake(int[] arr, int count) {

        int left = 0;
        int right = count;

        while (left < right) {
            int swap = arr[left];
            arr[left] = arr[right];
            arr[right] = swap;
            left++;
            right--;
        }
    }

    private static int findMaxIndex(int[] arr, int index) {

        int maxIndex = 0;

        for (int i = 1; i <= index; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
