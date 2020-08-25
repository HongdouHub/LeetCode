package leetcode.t1_t10.t9_IsPalindrome;

/**
 * 9. 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 输入: 121
 * 输出: true
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(10201));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int div = 1;
        int left;
        int right;

        while ((x / div) >= 10) {
            div *= 10;
        }

        while (x > 0) {
            left = x / div;
            right = x % 10;

            if (left != right) {
                return false;
            }

            // 抹掉高位和低位
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

}
