package leetcode.t151_200.t169_Majority;

/**
 * 求众数 : count(x) > n/2
 *
 * 方法一： 暴力求解： Loop : Loop count(x) -- O(N^2)
 * 方法二： Map<x, count(x)> -- O(N)
 * 方法三： 先sorted ，再看重复的数据是否大于 n/2，如果有就是解
 * 方法四： 分治的做法，左半部分找最多的数，右边也找最多的数：
 *               要多加判断，不然有bug
 *          a. left == right -> left
 *          b. left > right  -> left
 *          c. left < right  -> right
 */
public class Majority {

    public static void main(String[] args) {

    }



}
