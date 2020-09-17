package leetcode.preparation;

public class TestCount {

    public static void main(String[] args) {
        long count = 100_000_000;
        test1(count);
        test2(count);
    }

    private static void test1(long count) {
        long start, sum = 0;
        int temp;
        for (int i = 0; i < count; i++) {
            start = System.currentTimeMillis();

            // 注意：'加减符号' 和 '右移符号'在计算优先级上是相同的
            temp = (999_999) >> 1;

            sum += (System.currentTimeMillis() - start);
        }

        System.out.println(String.format("测试右移方案（%d次）总耗时：%d", count, sum));
    }

    private static void test2(long count) {
        long start, sum = 0;
        int temp;
        for (int i = 0; i < count; i++) {
            start = System.currentTimeMillis();

            temp = (999_999) / 2;

            sum += (System.currentTimeMillis() - start);
        }

        System.out.println(String.format("测试除法方案（%d次）总耗时：%d", count, sum));
    }

}
