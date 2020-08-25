package leetcode.t1118_NumberOfDays;

@SuppressWarnings("all")
public class NumberOfDays {

    public static void main(String[] args) {
        System.out.println(numberOfDays(1992, 7));
        System.out.println(numberOfDays(2000, 2));
        System.out.println(numberOfDays(1900, 2));
        System.out.println(numberOfDays(100, 2));
    }

    private static int numberOfDays(int Y, int M) {
        int[] monthOfDay = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (M == 2 && isLeap(Y)) {
            return 29;
        } else {
            return monthOfDay[M];
        }
    }

    private static boolean isLeap(int year) {
        // 闰年判定方法：能被400整除。或者能被4整除但不能被100整除
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

}
