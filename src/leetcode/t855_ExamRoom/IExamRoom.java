package leetcode.t855_ExamRoom;

public interface IExamRoom {

    /**
     * 返回一个 int （整型数据），代表学生坐的位置；
     */
    int seat();

    /**
     * 代表坐在座位 p 上的学生现在离开了考场。
     */
    void leave(int p);

}
