package leetcode.t101_150.t121_122_123_309_188_714_GuPiao.t121_122_123_188;

public class t123 {

    public static void main(String[] args) {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        // 4 + 3 = 7

        System.out.println(calMaxProfit(prices, 2));
    }

    private static int calMaxProfit(int[] prices, int times) {
        int size;
        if (prices == null || (size = prices.length) == 0) return 0;

        int maxProfit = 0;
        int[][] mp = new int[times + 1][size];

        for (int time = 1; time <= times; time++) {
            int tempMax = mp[time - 1][0] - prices[0];

            for (int i = 1; i < size; i++) {
                mp[time][i] = Math.max(mp[time][i - 1], tempMax + prices[i]);
                tempMax = Math.max(tempMax, mp[time - 1][i] - prices[i]);
                maxProfit = Math.max(mp[time][i], maxProfit);
            }
        }
        return maxProfit;
    }

}
