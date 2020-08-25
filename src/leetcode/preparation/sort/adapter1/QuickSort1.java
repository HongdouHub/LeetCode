package leetcode.preparation.sort.adapter1;

public class QuickSort1 {

    public static int[] sort(int[] input) {
        int length;
        if (input == null || (length = input.length) == 0) {
            return new int[0];
        }

        return quickSort(input, 0, length - 1);
    }

    private static int[] quickSort(int[] input, int start, int end) {
        // 枢轴
        int pivotLocation = input[start];
        int i = start;
        int j = end;

        while (i < j) {

            while ((i < j) && input[j] > pivotLocation) {
                j--;
            }

            while ((i < j) && input[i] < pivotLocation) {
                i++;
            }

            if ((i < j) && input[i] == input[j]) {
                i++;
            } else if (i != j) {
                swap(input, i, j);
            }
        }

        if (i - 1 > start) {
            quickSort(input, 0, i - 1);
        }

        if (j + 1 < end) {
            quickSort(input, j + 1, end);
        }
        return input;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
