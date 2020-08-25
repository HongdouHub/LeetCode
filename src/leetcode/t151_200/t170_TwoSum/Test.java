package leetcode.t151_200.t170_TwoSum;

/**
 * 170. 两数之和 III - 数据结构设计
 *
 * 设计b并实现一个 TwoSum_TwoPointers 类。他需要支持以下操作:add 和 find。
 *      add -把这个数添加到内部的数据结构。
 *      find -是否存在任意一对数字之和等于这个值
 *
 * 样例 1:
 *     add(1);add(3);add(5);
 *     find(4)//返回true
 *     find(7)//返回false
 */
public class Test {

    public static void main(String[] args) {
        // 双指针法
        TwoSum_TwoPointers twoPointers = new TwoSum_TwoPointers();
        test(twoPointers, new int[]{1, 3, 5}, new int[]{4, 7});

        // 哈希表法
        TwoSum_HashMap hashMap = new TwoSum_HashMap();
        test(hashMap, new int[]{1, 3, 5}, new int[]{4, 7});
    }

    private static void test(TwoSum twoSum, int[] add, int[] find) {
        for (int i = 0; i < add.length; i++) {
            twoSum.add(add[i]);
        }
        for (int i = 0; i < find.length; i++) {
            System.out.println(twoSum.find(find[i]));
        }
        System.out.println("----------------");
    }

}
