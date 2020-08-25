package leetcode.t151_200.t191_338_CountingBits;

/**
 * 位1的个数
 */
public class HammingWeight {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(hammingWeight(n));
    }

    private static int hammingWeight(int n) {
        int result = 0;

        int bits = n;
        while (bits != 0) {
//            if ((bits & -bits) > 0) {
//                result++;
//            }
            result++;
            bits = bits & (bits - 1);
        }
        return result;
    }

}
