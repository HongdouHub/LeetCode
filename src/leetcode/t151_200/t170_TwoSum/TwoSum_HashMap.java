package leetcode.t151_200.t170_TwoSum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 哈希表法
 *
 * 时间复杂度：
 *      - add(number)： O(1)
 *      - find(value)： O(N)
 *
 * 空间复杂度：
 *      - O(N)
 */
public class TwoSum_HashMap implements TwoSum {

    private Map<Integer, Integer> countsMap;

    public TwoSum_HashMap() {
        this.countsMap = new ConcurrentHashMap<>();
    }

    @Override
    public void add(int number) {
        countsMap.put(number, countsMap.getOrDefault(number, 0) + 1);
    }

    @Override
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : countsMap.entrySet()) {
            int key = value - entry.getKey();

            if ((key == entry.getKey() && entry.getValue() > 1)
                    || (key != entry.getKey() && countsMap.containsKey(key))) {
                return true;
            }
        }
        return false;
    }
}
