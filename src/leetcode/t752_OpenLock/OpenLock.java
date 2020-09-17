package leetcode.t752_OpenLock;

import java.util.*;

/**
 * 752. 打开转盘锁
 *
 * 你有一个带有四个圆形拨轮的转盘锁。
 * 每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。
 * 每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，
 * 这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，
 * 你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * 示例 1:
 *      输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 *      输出：6
 *      解释：
 *          可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 *          注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 *          因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * 示例 2:
 *      输入: deadends = ["8888"], target = "0009"
 *      输出：1
 *      解释：
 *          把最后一位反向旋转一次即可 "0000" -> "0009"。
 */
@SuppressWarnings("all")
public class OpenLock {

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{
                "0201","0101","0102","1212","2002"}, "0202")); // 6

        System.out.println(openLock(new String[]{"8888"}, "0009")); // 1
    }

    /**
     * 广度优先遍历
     *
     * 时间复杂度：O(N^2 · A^N + D)。
     *      A 表示数字的个数，
     *      N 表示状态的位数，
     *      D 表示数组 deadends 的大小。
     *      在最坏情况下，我们需要搜索完所有状态，状态的总数为 O(A^N)。
     *      对于每个状态，我们要枚举修改的位置，需要 O(N) 的时间，
     *      枚举后得到新的状态同样需要 O(N) 的时间。
     *
     * 空间复杂度：O(A^N + D)，用来存储队列以及 deadends 的集合。
     */
    private static int openLock(String[] deadends, String target) {

        // Set，用来判断密码值是否是死亡数组中的值，这样就不用for循环来遍历了
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        // Set，用来判断某一密码值相邻密码值是否重复出现，防止死循环
        Set<String> visited = new HashSet<>();

        // Queue，队列，BFS要用到
        Queue<String> queue = new LinkedList();

        queue.offer("0000");
        visited.add("0000");

        int step = 0;

        // 当所有密码值的情况都到时结束
        while (!queue.isEmpty()) {
            int len = queue.size();

            // 遍历队列中的密码值
            for (int i = 0; i < len; i++) {

                String s = queue.poll();

                // 如果死亡数组中包含当前密码值，跳过循环，因为这时密码值已经被锁定，不能进行下一步了
                if (deadSet.contains(s)) {
                    continue;
                }

                if (target.equals(s)) {
                    return step;
                }

                // 遍历当前密码值的相邻8个密码值并作判断是否重复出现
                for (int j = 0; j < 4; j++) {
                    String up = up(s, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }

                    String down = down(s, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            // 当前树的一层遍历结束，步数+1
            step++;
        }
        //无解，返回-1
        return -1;
    }

    private static String up (String s, int j) {
        char[] c = s.toCharArray();
        if (c[j] == '9') {
            c[j] = '0';
        } else {
            c[j]++;
        }
        return new String(c);
    }

    private static String down (String s, int j) {
        char[] c = s.toCharArray();
        if (c[j] == '0') {
            c[j] = '9';
        } else {
            c[j]--;
        }
        return new String(c);
    }

    public static int tnt(String[] deadends, String target) {
        TNT tnt = new TNT();
        People people = new People("Eingate");
        people.set(tnt);
        tnt.start();
        people.runaway();
        return tnt.boom();
    }

    private static class TNT {

        public void start() {
        }

        public int boom() {
            return 0;
        }
    }

    private static class People {

        public People(String name) {

        }


        public void set(TNT tnt) {

        }

        public void runaway() {

        }
    }

}
