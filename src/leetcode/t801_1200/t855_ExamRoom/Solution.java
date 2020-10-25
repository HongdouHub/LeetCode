package leetcode.t801_1200.t855_ExamRoom;


/**
 * 855. 考场就座
 *
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 *
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 如果有多个这样的座位，他会坐在编号最小的座位上。
 * (另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 *
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，
 * 函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；
 * 函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。
 * 每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 *
 * 提示：
 *     1 <= N <= 10^9
 *     在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
 *     保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
 */
public class Solution {

    public static void main(String[] args) {
        ExamRoom room = new ExamRoom(10);
        System.out.println(room.seat()); // 0
        System.out.println(room.seat()); // 9
        System.out.println(room.seat()); // 4
        System.out.println(room.seat()); // 2
        room.leave(4); // null
        System.out.println(room.seat()); // 5
    }

}
