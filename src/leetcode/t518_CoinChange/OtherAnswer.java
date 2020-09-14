package leetcode.t518_CoinChange;

import java.util.ArrayList;
import java.util.List;

public class OtherAnswer {

    /**
     * 通过回溯算法，可得到可能解的全排列
     */
    public static int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(amount, coins, path, result);

        return result.size();
    }

    private static void dfs(int amount, int[] coins,
                            List<Integer> path, List<List<Integer>> result) {
        if (amount == 0) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < coins.length; i++) {
            if (amount < coins[i]) {
                continue;
            }

            Integer integer = coins[i];
            path.add(integer);

            dfs(amount - coins[i], coins, path, result);

            path.remove(integer);
        }
    }

}
