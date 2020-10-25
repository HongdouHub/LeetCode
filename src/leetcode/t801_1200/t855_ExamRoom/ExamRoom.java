package leetcode.t801_1200.t855_ExamRoom;

import java.util.TreeSet;

/**
 * 使用 TreeSet
 *
 * 时间复杂度： O(P)，P 是当前入座学生的数目
 *      seat()   :  遍历整个有序集合 - O(P)
 *      leave()  :  遍历树高 - O(logP)
 *
 * 空间复杂度： O(P)，P 是当前入座学生的数目，用于存储有序集合。
 */
public class ExamRoom implements IExamRoom {

    private int N;
    private TreeSet<Integer> mStudents;

    public ExamRoom(int N) {
        this.N = N;
        this.mStudents = new TreeSet<>();
    }

    @Override
    public int seat() {

        // 下一个学生的座位（从零开始）
        int seat = 0;

        if (!mStudents.isEmpty()) {

            // 最左边到第一个学生，之间的距离
            int first = mStudents.first();
            Integer prev = null;

            for (Integer student : mStudents) {
                if (prev != null) {
                    int distance = (student - prev) / 2;

                    if (distance > first) {
                        first = distance;
                        seat = prev + distance;
                    }
                }
                prev = student;
            }

            if (N - 1 - mStudents.last() > first) {
                seat = N - 1;
            }
        }

        mStudents.add(seat);

        return seat;
    }

    @Override
    public void leave(int p) {
        mStudents.remove(p);
    }
}
