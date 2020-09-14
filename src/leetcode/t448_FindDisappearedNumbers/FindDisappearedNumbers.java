package leetcode.t448_FindDisappearedNumbers;

import leetcode.preparation.MethodBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.ConsoleUtils.println;

/**
 * 448. 找到所有数组中消失的数字
 * <p>
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，
 * 数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗?
 * 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * 输入: [4,3,2,7,8,2,3,1]
 * 输出: [5,6]
 */
@SuppressWarnings("all")
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        test("findDisappearedNumbers1");
        test("findDisappearedNumbers2");
    }

    private static void test(String methodName) {
        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(FindDisappearedNumbers.class)
                .setMethodName(methodName)
                .setParameterTypes(new Class[]{int[].class})
                .build();

        println((List) builder.invoke(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    /**
     * 使用哈希表
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    private static List<Integer> findDisappearedNumbers1(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new ArrayList<>();
        }

        Map<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            hashMap.put(nums[i], true);
        }

        List<Integer> result = new ArrayList<>();

        // 1 ≤ a[i] ≤ n
        for (int i = 1; i < length + 1; i++) {
            if (!hashMap.containsKey(i)) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * 原地修改
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    private static List<Integer> findDisappearedNumbers2(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;

            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        List<Integer> result = new ArrayList<>();

        // 1 ≤ a[i] ≤ n
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

}
