package leetcode.t518_CoinChange;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.ConsoleUtils.println;

public class OtherAnswer {

    public static void main(String[] args) {
        println(change(5, new int[]{1, 2, 5}) + "\n\n");    // 9
        println(change(3, new int[]{2}) + "\n\n");          // 0
        println(change(10, new int[]{10}) + "\n\n");        // 1
    }

    /**
     * 通过回溯算法，可得到可能解的全排列
     *
     * 时间复杂度：O(N ^ 2)
     * 空间复杂度：O(N)
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

        System.out.println(GsonUtil.array2Json(result));
        return result.size();
    }

    private static void dfs(int amount, int[] coins,
                            List<Integer> path, List<List<Integer>> result) {
        if (amount == 0) {
            List<Integer> temp = new ArrayList<>(path);
            Collections.sort(temp);

            if (!result.contains(temp)) {
                result.add(temp);
            }
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
