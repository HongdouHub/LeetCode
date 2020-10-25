package leetcode.t151_200.t152_MaxProductSubarray;

import leetcode.preparation.MethodBuilder;

import static utils.ConsoleUtils.println;

/**
 * 152. 乘积最大子数组
 *
 * 给你一个整数数组 nums ，
 * 请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 *
 * 示例 1:
 *      输入: [2,3,-2,4]
 *      输出: 6
 *      解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 *      输入: [-2,0,-1]
 *      输出: 0
 *      解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
@SuppressWarnings("all")
public class Solution {

    public static void main(String[] args) {
        test(MaxProductSubarray1.class);
        test(MaxProductSubarray2.class);
        test(MaxProductSubarray3.class);
    }

    private static void test(Class clazz) {
        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(clazz)
                .setMethodName("maxProduct")
                .setParameterTypes(int[].class)
                .build();

        System.out.println(String.format("-------------%s------------", clazz.getSimpleName()));
        println(builder.invoke(new int[]{0, -1, 0, 0}));        // 0
        println(builder.invoke(new int[]{-1, -2, -9, -6}));     // 108
        println(builder.invoke(new int[]{2, 3, -2, 4}));        // 6
        println(builder.invoke(new int[]{-2, 0, -1}));          // 0
        System.out.println("----------------------------------------\n");
    }

}
