package leetcode.t887_SuperEggDrop;

import leetcode.preparation.MethodBuilder;
import leetcode.t887_SuperEggDrop.labuladong.SuperEggDrop2;
import leetcode.t887_SuperEggDrop.liweiwei1419.SuperEggDrop4;

/**
 * 887. 鸡蛋掉落
 *
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，
 * 从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * 示例 1：
 *      输入：K = 1, N = 2
 *      输出：2
 *      解释：
 *          鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 *          否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 *          如果它没碎，那么我们肯定知道 F = 2 。
 *          因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 *
 * 示例 2：
 *      输入：K = 2, N = 6
 *      输出：3
 *
 * 示例 3：
 *      输入：K = 3, N = 14
 *      输出：4
 */
@SuppressWarnings("all")
public class Solution {

    public static void main(String[] args) {
//        test(SuperEggDrop1.class);
//        test(SuperEggDrop2.class);
//        test(SuperEggDrop3.class);
        test(SuperEggDrop4.class);
    }

    private static void test(Class clazz) {
        Object o = null;
        try {
            o = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MethodBuilder builder = new MethodBuilder.Builder()
                .setClazz(clazz)
                .setObject(o)
                .setMethodName("superEggDrop")
                .setParameterTypes(new Class[]{int.class, int.class})
                .build();

        System.out.println(String.format("----------%s---------", clazz.getSimpleName()));
        System.out.println(builder.invoke(1, 2)); // 2
        System.out.println(builder.invoke(2, 6)); // 3
        System.out.println(builder.invoke(3, 14));// 4
        System.out.println(builder.invoke(2, 100));// 14
        System.out.println(builder.invoke(300, 100));// 7
        System.out.println(builder.invoke(7, 5000));// 13
        System.out.println("--------------------------------\n");
    }


}
