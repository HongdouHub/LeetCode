package leetcode.t645_FindErrorNums;

import leetcode.preparation.MethodBuilder;
import utils.GsonUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 645. 错误的集合
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
 * 导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 你的任务是首先寻找到重复出现的整数，再找到丢失的整数，
 * 将它们以数组的形式返回。
 *
 * 示例 1:
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 *
 * 注意:
 *     给定数组的长度范围是 [2, 10000]。
 *     给定的数组是无序的。
 */
@SuppressWarnings("all")
public class FindErrorNums {

    public static void main(String[] args) {
        test("findErrorNums1");
        test("findErrorNums2");
        test("findErrorNums3");
        test("findErrorNums4");
    }

    private static void test(String methodName) {
        MethodBuilder build = new MethodBuilder.Builder()
                .setClazz(FindErrorNums.class)
                .setMethodName(methodName)
                .setParameterTypes(new Class[]{int[].class})
                .build();

        System.out.println(String.format("------------%s----------", methodName));
        print(build.invoke(new int[] {1, 2, 2, 4}));    // 2, 3
        print(build.invoke(new int[] {2, 2}));          // 2, 1
        System.out.println("-----------------------------------\n");
    }

    private static void print(Object object) {
        System.out.println(GsonUtil.array2Json(Arrays.asList((int[]) object)));
    }

    /**
     * 排序法 - 11 ms / 40 MB
     *
     * 时间复杂度：O(n · log n)
     * 空间复杂度：O(log n)
     */
    private static int[] findErrorNums1(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new int[0];
        }

        Arrays.sort(nums);
        int dup = -1;
        int missing = 1; // 此处必须是1

        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == nums[i]) {
                dup = nums[i - 1];
            } else if (nums[i] > nums[i - 1] + 1) {
                missing = nums[i - 1] + 1;
            }
        }

        missing = (nums[length - 1] != length) ? length : missing;
        return new int[] {dup, missing};
    }

    /**
     * 哈希表法 - 23 ms / 40.3 MB
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int[] findErrorNums2(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new int[0];
        }

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        int dup = -1;
        int missing = -1;

        for (int i = 1; i < length + 1; i++) {
            if (!hashMap.containsKey(i)) {
                missing = i;
            } else if (hashMap.get(i) >= 2) {
                dup = i;
            }
        }

        return new int[] {dup, missing};
    }

    /**
     * 额外数组法 - 2 ms / 40.6 MB
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int[] findErrorNums3(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new int[0];
        }

        int[] array = new int[length + 1];
        Arrays.fill(array, 0);

        for (int i = 0; i < length; i++) {
            array[nums[i]] += 1;
        }

        int dup = -1;
        int missing = -1;

        for (int i = 1; i < length + 1; i++) {
            if (array[i] == 0) {
                missing = i;
            } else if (array[i] >= 2) {
                dup = i;
            }
        }

        return new int[] {dup, missing};
    }

    /**
     * 额外空间法 - 2 ms / 40.1 MB
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] findErrorNums4(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new int[0];
        }

        int dup = -1;
        int missing = -1;

        for (int i = 0; i < length; i++) {
            // 数据范围： [1, n];
            // 下标范围： [0, n - 1]
            int index = Math.abs(nums[i])  - 1;

            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }

        return new int[] {dup, missing};
    }
}
