package leetcode.t451_650.t560_SubArraySum;

import leetcode.preparation.MethodBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 说明 :
 *     数组的长度为 [1, 20,000]。
 *     数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class SubArraySum {

    public static void main(String[] args) {
        test("subarraySum1");
        test("subarraySum2");
    }

    private static void test(String methodName) {
        MethodBuilder build = new MethodBuilder.Builder()
                .setClazz(SubArraySum.class)
                .setParameterTypes(int[].class, int.class)
                .setMethodName(methodName)
                .build();

        System.out.println(String.format("------------%s-----------", methodName));
        System.out.println(build.invoke(new int[] {1, 1, 1}, 2));               // 2
        System.out.println(build.invoke(new int[] {28,54,7,-70,22,65,-6}, 100));// 1
        System.out.println("-----------------------------------\n");
    }

    /**
     * 枚举法
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static int subarraySum1(int[] nums, int k) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 前缀和 + 哈希表优化
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int subarraySum2(int[] nums, int k) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }

        int count = 0;
        int pre = 0;

        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        for (int i = 0; i < length; i++) {
            pre += nums[i];

            if (hashMap.containsKey(pre - k)) {
                count += hashMap.get(pre - k);
            }

            // 定义 pre[i] 为 [0..i] 里所有数的和，则 pre[i] = pre[i−1] + nums[i]
            // 「[j..i] 这个子数组和为 k 」这个条件我们可以转化为:
            // pre[i] − pre[j−1] == k
            hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);
        }

        return count;
    }
}
