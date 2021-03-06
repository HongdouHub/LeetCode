package leetcode.preparation;

@SuppressWarnings("all")
public class TestMove {

    public static void main(String[] args) {
        //  最大值
        //  0111_1111_1111_1111_1111_1111_1111_1111
        System.out.println(((long) 1 << 31) - 1 == Integer.MAX_VALUE);
        System.out.println(((long) Math.pow(2, 31) - 1) == Integer.MAX_VALUE);

        //  最小值
        // -1000_0000_0000_0000_0000_0000_0000_0000
        System.out.println((-(long) 1 << 31) == Integer.MIN_VALUE);
        System.out.println(((long) -Math.pow(2, 31)) == Integer.MIN_VALUE);
    }
}
