package leetcode.t101_150.t121_122_123_309_188_714_GuPiao.t121_122_123_188;

public class t121 {

    public static void main(String[] args) {
        int[] raw = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(CommMethod.calMaxProfit(raw, 1));
        System.out.println(calMaxProfit(raw));


    }

    private static int calMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minValue = prices[0];
        int result = 0;

        for (int price : prices) {
            if (minValue > price) {
                minValue = price;
            }

            System.out.println("比较前：" + result);
            if (result < price - minValue) {
                result = price - minValue;
            }
            System.out.println("比较后：" + result);
            System.out.println();
        }
        return result;
    }

}
