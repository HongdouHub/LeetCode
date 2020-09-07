package leetcode.t384_Solution;

/**
 * 384. 打乱数组
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution1 solution = new Solution1(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class Test {

    public static void main(String[] args) {
        test(new Solution1(new int[] {1, 2, 3}));
        test(new Solution2(new int[] {1, 2, 3}));
    }

    private static void test(ISolution solution) {
        System.out.println("shuffle:" + Utils.asList(solution.shuffle()));
        System.out.println(" reset :" + Utils.asList(solution.reset()));
        System.out.println("shuffle:" + Utils.asList(solution.shuffle()));
        System.out.println("------------------------\n");
    }

}
