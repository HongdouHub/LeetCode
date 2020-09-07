package leetcode.t382_Solution;

import static leetcode.preparation.linkednode.PrepareListNode.generate;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution(generate(new Integer[]{1, 2, 3}));
        System.out.println(solution.getRandom());
    }

}
