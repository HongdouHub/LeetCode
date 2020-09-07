package leetcode.t384_Solution;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Integer> asList(int[] input) {
        int length;
        if (input == null || (length = input.length) == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(input[i]);
        }

        return result;
    }

}
