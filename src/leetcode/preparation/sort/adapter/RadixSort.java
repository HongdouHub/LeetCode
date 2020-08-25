package leetcode.preparation.sort.adapter;

/**
 * 基数排序
 * <p>
 * 根据键值的每位数字来分配桶；
 *
 * 最佳时间复杂度：O(n * k)
 * 平均时间复杂度：O(n * k)
 * 最差时间复杂度：O(n * k)
 * 空间复杂度：O(n + k)
 *
 * 稳定性：稳定
 * 复杂性：较复杂
 */
public class RadixSort {

    // 基数为10，即10进制，最大有10种可能，即最多需要10个桶来映射数组元素
    private static int DEFAULT_RADIX_N = 10;

    public static int[] sort(int[] input) {
        int length;
        if (input == null || (length = input.length) == 0) {
            return new int[0];
        }

        int d = maxBit(input, length);
        int[] tmp = new int[length];
        int[] count = new int[10]; //计数器
        int i, j, k;
        int radix = 1;

        //进行d次排序
        for (i = 1; i <= d; i++) {

            //每次分配前清空计数器
            for (j = 0; j < 10; j++) {
                count[j] = 0;
            }

            //统计每个桶中的记录数
            for (j = 0; j < length; j++) {
                k = (input[j] / radix) % 10;
                count[k]++;
            }

            //将tmp中的位置依次分配给每个桶
            for (j = 1; j < 10; j++) {
                count[j] = count[j - 1] + count[j];
            }

            //将所有桶中记录依次收集到tmp中
            for (j = length - 1; j >= 0; j--) {
                k = (input[j] / radix) % 10;
                tmp[count[k] - 1] = input[j];
                count[k]--;
            }

            //将临时数组的内容复制到data中
            for (j = 0; j < length; j++) {
                input[j] = tmp[j];
            }

            radix = radix * 10;
        }
        return input;
    }

    /**
     * //辅助函数，求数据的最大位数
     */
    private static int maxBit(int[] input, int n) {

        // 最大数
        int maxData = input[0];

        // 先求出最大数，再求其位数，这样有原先依次每个数判断其位数，稍微优化点。
        for (int i = 1; i < n; ++i) {
            if (maxData < input[i]) {
                maxData = input[i];
            }
        }

        int d = 1;
        int p = 10;
        while (maxData >= p) {
            //p *= 10; // Maybe overflow
            maxData /= 10;
            ++d;
        }
        return d;
        /*    int d = 1; //保存最大的位数
            int p = 10;
            for(int i = 0; i < n; ++i) {
                while(data[i] >= p) {
                    p *= 10;
                    ++d;
                }
            }
            return d;*/
    }
}
