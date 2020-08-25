package leetcode.preparation.sort;

import utils.GsonUtil;

import java.lang.reflect.Method;
import java.util.Arrays;

@SuppressWarnings("all")
public class Test {

    private static Class clazz = SortUtils.class;

    private static int[] TEST = new int[]{42, 30, 68, 98, 86, 15, 57};

    public static void main(String[] args) throws Exception {
        System.out.println("\n-----冒泡排序-----");
        sort(method("bubbleSort"), new int[]{10, 9, 8, 7, 5, 6, 4, 3, 2, 1});

        System.out.println("\n-----选择排序-----");
        sort(method("selectionSort"), new int[]{10, 9, 8, 7, 5, 6, 4, 3, 2, 1});

        System.out.println("\n-----插入排序-----");
        sort(method("insertionSort"), new int[]{10, 9, 8, 7, 5, 6, 4, 3, 2, 1});

        System.out.println("\n-----归并排序-----");
        sort(method("mergeSort"), new int[]{10, 9, 8, 7, 5, 6, 4, 3, 2, 1});

        System.out.println("\n-----快速排序-----");
        sort(method("quickSort"), new int[]{10, 9, 8, 7, 5, 6, 4, 3, 2, 1});

        System.out.println("\n-----希尔排序-----");
        sort(method("shellSort"), new int[]{10, 9, 8, 7, 5, 6, 4, 3, 2, 1});

        System.out.println("\n-----基数排序-----");
        sort(method("radixSort"), new int[]{10, 9, 8, 7, 5, 6, 4, 3, 2, 1});

        System.out.println("\n-----计数排序-----");
        sort(method("countingSort"), new int[]{10, 9, 8, 7, 5, 6, 4, 3, 2, 1});

    }

    private static Method method(String name) throws Exception {
        return clazz.getMethod(name, int[].class);
    }

    private static void sort(Method method, int[] raw) {
        try {
            int[] parse = Arrays.copyOf(raw, raw.length);
            int[] result = (int[]) method.invoke(clazz, parse);

            System.out.print(GsonUtil.array2Json(Arrays.asList(raw)));
            System.out.print(" -> ");
            System.out.println(GsonUtil.array2Json(Arrays.asList(result)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
