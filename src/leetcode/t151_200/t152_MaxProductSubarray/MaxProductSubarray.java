package leetcode.t151_200.t152_MaxProductSubarray;

import java.util.ArrayList;
import java.util.List;

/**
 * 乘积最大子序列
 *
 * 用零分割出多段数组，每段数组的负数个数为： 奇数（头尾遍历找最大）；偶数（相乘最大）
 */
@SuppressWarnings("all")
public class MaxProductSubarray {

    public static void main(String[] args) {
        int[] raw = new int[]{0, -1, 0, 0};
        System.out.println(getMaxValue(raw));
    }

    private static long getMaxValue(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.add(new ArrayList<Integer>());
            } else {
                list.get(list.size() - 1).add(nums[i]);
            }
        }

        Integer maxValue = null;
        for (List<Integer> child : list) {
            int value = getItemMaxValue(child);
            if (maxValue == null || value > maxValue) {
                maxValue = value;
            }
        }
        return list.size() == 1 ? maxValue :
                maxValue < 0 ? 0 : maxValue;
    }

    private static int getItemMaxValue(List<Integer> child) {
        if (child.isEmpty()) {
            return 0;
        } else if (child.size() == 1) {
            return child.get(0);
        }

        // 负数的个数
        long negativeSize = 0;
        Integer leftIndex = null;
        Integer rightIndex = null;

        for (int i = 0; i < child.size(); i++) {
            if (child.get(i) < 0) {
                if (leftIndex == null) {
                    leftIndex = i;
                }
                rightIndex = i;
                negativeSize++;
            }
        }

        int maxValue = 1;
        // 偶数个负数
        if ((negativeSize & 1) == 0) {
            for (Integer integer : child) {
                maxValue *= integer;
            }
            return maxValue;
        }

        int leftValue = 1;
        int rightValue = 1;
        // 奇数个负数
        for (int i = 0; i < rightIndex; i++) {
            leftValue *= child.get(i);
        }
        for (int i = child.size() - 1; i > leftIndex; i--) {
            rightValue *= child.get(i);
        }
        return Math.max(leftValue, rightValue);
    }

}
