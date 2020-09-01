package leetcode.t319_BulbSwitch;

/**
 * 319. 灯泡开关
 *
 * 初始时有 n 个灯泡关闭。
 * 第 1 轮，你打开所有的灯泡。
 * 第 2 轮，每两个灯泡你关闭一次。
 * 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。
 * 第 i 轮，每 i 个灯泡切换一次开关。
 * 对于第 n 轮，你只切换最后一个灯泡的开关。
 *
 * 找出 n 轮后有多少个亮着的灯泡。
 *
 * 输入: 3
 * 输出: 1
 * 解释:
 * 初始时,   灯泡状态 [关闭, 关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启, 关闭].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭, 开启].
 */
public class BulbSwitch {

    /**
     * 1）分析：
     * 第j轮的第i个灯泡的状态判断方法：
     * 将包含本轮在内的对第i个灯泡的所有操作次数做和，记为Sij。
     * 若Sij为奇数，说明第i个灯泡，经过j轮以后，是亮着的，因为第0轮一定是关闭的。
     * 同理，若Sij为偶数，说明第i个灯泡，经过j轮以后，是关闭的。
     *
     * 所以问题转变为：
     * 经过n轮，第i个灯泡被操作了奇数次还是偶数次？奇数次则最后是亮的，偶数次则最后是关闭的。
     *
     * 2）观察：
     * 第j轮操作的灯泡的位置，一定是j的倍数。咱们反向观察一下：
     * 第10个灯泡在什么时候会被操作？第1轮，第2轮，第5轮，第10轮
     *
     * 第 i 个灯泡只有在第 k 轮会被操作，而 k 一定是 i 的因数。并且 n>=k。
     * 所以如果一个数的因数的个数为奇数个，那么它最后一定是亮的，否则是关闭的。
     *
     * 3）讨论：
     * 什么数的因数的个数是奇数个？
     *
     * 4）结论：
     * 完全平方数  ->   P = A * B 【此时 A 和 B 相等，只贡献一次】
     *
     * 5）问题翻译：
     * 找出小于某个数的前提下，它其中有多少个完全平方数（还亮着灯）
     */
    public static void main(String[] args) {
        System.out.println(bulbSwitch(1));
        System.out.println(bulbSwitch(3));
        System.out.println(bulbSwitch(4));
        System.out.println(bulbSwitch(9));
    }

    private static int bulbSwitch(int n) {
        if (n == 1) {
            return 1;
        }

        int result = 1;
        while (true) {
            if (result * result > n) {
                break;
            }

            result++;
        }

        return result - 1;
    }

}