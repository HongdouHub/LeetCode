package leetcode.t31_100.t51_52_NQueens;

import java.util.Stack;

/**
 * 二进制：1表示该位置被攻击， 0表示该位置安全
 */
public class NQueens2 {
    private static int sCount;
    private static Stack<String> sStack = new Stack<>();

    /**
     * 得到有效空位，用于放置皇后
     *
     * col | pie | na 的结果中 0表示之前的皇后没有攻击到的位置
     * ~(col | pie | na) 取反将 0变为 1(没有攻击到的位置)，但是总长是32位，高位都为 1（无用）
     *
     * 假设：sN = 8;
     * (1 << sN) - 1 = 0000...00 1111 1111（总长32位）
     *
     * (~(col | pie | na)) & ((1 << sN) - 1)
     * 则找到当前层可以放置皇后的位置：
     *      其中 1表示：之前的皇后没有攻击到的位置，
     *      其中 0表示：无效或者被攻击到的位置
     */
    public static void main(String[] args) {
        sCount = 0;
        int n = 5;
        dfs(n, 0, 0, 0, 0);
        System.out.println(sCount);

        System.out.println(1 << 4);
        System.out.println(10 >> 2);
    }

    private static void dfs(int n, int row, int col, int pie, int na) {
//        System.out.println(String.format("执行dfs - row=%s, col=%s【%s】, pie=%s, na=%s", String.valueOf(row), String.valueOf(col),
//                toBinaryString(col), toBinaryString(pie), toBinaryString(na)));
        if (row >= n) {
            sCount++;
            printAndClear();
            return;
        }

        int bits = (~(col | pie | na)) & ((1 << n) - 1);

//        System.out.println("col | pie | na=" + toBinaryString(col | pie | na));
//        System.out.println("~(col | pie | na)=" + toBinaryString(~(col | pie | na)));
//        System.out.println("*** bits=" + toBinaryString(bits) + "\n");

        while (bits > 0) {

            // 得到一个空位，例子： sBits=101，-sBits=011，那么p=001（得到右边第一个1）
            int p = bits & -bits;
            push(p, n);
//            System.out.println("while: bits=" + toBinaryString(bits));
//            System.out.println("while: -bits=" + toBinaryString(-bits));
//            System.out.println("while: int p=" + toBinaryString(p));
//            System.out.println("\n" + String.format("递归调用 - 【col|p】=%s, 【(pie|p) << 1】=%s, 【(na | p) >> 1=%s】",
//                    toBinaryString(col | p), toBinaryString((pie | p) << 1), toBinaryString((na | p) >> 1)));

            // 把空位给到对应的列、撇和捺
            dfs(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);

            // 将最后一个 1-bit 去掉，例子： sBits=101，sBits-1=100，那么新sBits=100（去掉右边第一个1）
            bits &= bits - 1;
            pop();
//            System.out.println("while: bits = bits & (bits - 1) = " + toBinaryString(bits));
        }
    }

    private static String toBinaryString(int n, int size) {
        String s = Integer.toBinaryString(n);
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

    private static void push(int n, int size) {
        String binaryString = toBinaryString(n, size);
        sStack.push(binaryString.replaceAll("1", "Q")
                .replaceAll("0", "."));
    }

    private static void pop() {
        if (!sStack.isEmpty()) {
            String pop = sStack.pop();
        }
    }

    private static void printAndClear() {
        while (!sStack.isEmpty()) {
            System.out.println(sStack.pop());
        }
        System.out.println();
    }
}
