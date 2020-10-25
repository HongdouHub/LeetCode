package leetcode.t301_350.t338_CountingBits;

/**
 * 338. 比特位计数
 *
 * 给定一个非负整数 num
 * 对于 0 <= i <= num 范围中的每个数字 i
 * 计算其二进制数中的 1 的数目，并将它们作为数组返回。
 */
public class CountingBits {

    public static void main(String[] args) {

        printData(getCountBits(2));     // [0,1,1]
        printData(getCountBits(5));     // [0,1,1,2,1,2]
        printData(getCountBits(10));
    }

    /**
     * i & （i - 1） 去除二进制数中最小的 1
     *
     * 时间复杂度： O(n)
     * 空间复杂度： O(1)
     */
    private static int[] getCountBits(int num) {
        int[] data = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            data[i] = data[i & (i - 1)] + 1;
        }
        return data;
    }

    private static void printData(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {

            System.out.println(String.format("%3d - ", i) +
                    toBinaryString(i, 8) + String.format(" ( %d 个1 )", arrays[i]));
        }
    }

    private static String toBinaryString(int data, int size) {
        String s = Integer.toBinaryString(data);
        if (s.length() > size) {
            s = s.substring(s.length() - size);
        }
        int minus = size - s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < minus; i++) {
            builder.append("0");
        }
        builder.append(s);
        return builder.toString();
    }
}
