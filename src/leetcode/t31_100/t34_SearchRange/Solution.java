package leetcode.t31_100.t34_SearchRange;

import leetcode.preparation.MethodBuilder;
import utils.GsonUtil;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
public class Solution {

    public static void main(String[] args) {
        test(SearchRange.class, "searchRange");

        test(SearchRangeLeft.class, "searchRange1");
        test(SearchRangeLeft.class, "searchRange2");

        test(SearchRangeRight.class, "searchRange1");
        test(SearchRangeRight.class, "searchRange2");
    }

    private static void test(Class clazz, String methodName) {
        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(clazz)
                .setMethodName(methodName)
                .setParameterTypes(int[].class, int.class)
                .build();

        System.out.println(String.format("-------------%s------------", methodName));
        print((int[]) builder.invoke(new int[]{5, 7, 7, 8, 10}, 8));       // [3,3]
        print((int[]) builder.invoke(new int[]{5, 7, 7, 8, 8, 10}, 8));    // [3,4]
        print((int[]) builder.invoke(new int[]{5, 7, 7, 8, 8, 10}, 6));    // [-1,-1]
        print((int[]) builder.invoke(new int[]{1}, 0));                    // [-1,-1]
        System.out.println("----------------------------------------\n");
    }

    private static void print(int[] data) {
        System.out.println(GsonUtil.array2Json(Arrays.asList(data)));
    }

}
