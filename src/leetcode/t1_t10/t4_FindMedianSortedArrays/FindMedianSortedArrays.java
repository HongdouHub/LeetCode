package leetcode.t1_t10.t4_FindMedianSortedArrays;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class FindMedianSortedArrays {


    public static void main(String[] args) {
        test(new int[]{1, 2}, new int[]{3, 4}); // 2.5
        test(new int[]{1, 3}, new int[]{2});    // 2
        test(new int[]{1, 2}, new int[]{-1, 3});// 1.5
        test(new int[]{1, 3, 4, 9}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}); // 4.5
    }

    private static void test(int[] input1, int[] input2) {
        System.out.println(findMedianSortedArrays1(input1, input2));
        System.out.println(findMedianSortedArrays2(input1, input2)); // *
        System.out.println(findMedianSortedArrays3(input1, input2)); // *
//        System.out.println(findMedianSortedArrays4(input1, input2));
        System.out.println("------------------");
    }

    /**
     * 归并排序
     *
     * 时间复杂度：遍历全部数组 (m+n)
     *
     * 空间复杂度：开辟了一个数组，保存合并后的两个数组 O(m+n)
     */
    private static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    /**
     * 归并排序（优化）
     *
     * 时间复杂度：(m+n)/2 -> O(m+n)
     *
     * 空间复杂度： 8 个变量 -> O(1)
     */
    private static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;

        int left = -1, right = -1;
        int nums1Index = 0, nums2Index = 0;

        for (int i = 0; i <= length / 2; i++) {
            left = right;

            if (nums1Index < m && (nums2Index >= n || nums1[nums1Index] < nums2[nums2Index])) {
                right = nums1[nums1Index++];
            } else {
                right = nums2[nums2Index++];
            }
        }

        if ((length & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    /**
     * 二分法查找 - 递归
     *
     * 时间复杂度：每进行一次循环，我们就减少 k/2 个元素，所以时间复杂度是 O(log(k)，
     *              而 k=(m+n)/2，所以最终的复杂也就是 O(log(m+n）)
     *
     * 空间复杂度：虽然我们用到了递归，但是可以看到这个递归属于尾递归，
     *              所以编译器不需要不停地堆栈，所以空间复杂度为 O(1)
     */
    private static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        // 将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) +
                getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1, int start1, int end1,
                              int[] nums2, int start2, int end2,
                              int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        // 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }

        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        // 计算待排除的数据下标，假如总数据长度为14，那么此时K=7，一次就可以排除(7 / 2) = 3个
        int remove1 = start1 + Math.min(len1, k / 2) - 1;
        int remove2 = start2 + Math.min(len2, k / 2) - 1;

        // 比较两个二分判断的节点
        // 去除较小的节点以及其前面的下标
        if (nums1[remove1] < nums2[remove2]) {
            return getKth(nums1, remove1 + 1, end1, nums2, start2, end2, k - (remove1 - start1 + 1));
        } else {
            return getKth(nums1, start1, end1, nums2, remove2 + 1, end2, k - (remove2 - start2 + 1));
        }

//        if (nums1[remove1] > nums2[remove2]) {
//            return getKth(nums1, start1, end1, nums2, remove2 + 1, end2, k - (remove2 - start2 + 1));
//        } else {
//            return getKth(nums1, remove1 + 1, end1, nums2, start2, end2, k - (remove1 - start1 + 1));
//        }
    }

    /**
     * 二分法查找 - 自写
     *
     * 时间复杂度：每进行一次循环，我们就减少 k/2 个元素，所以时间复杂度是 O(log(k)，
     *              而 k=(m+n)/2，所以最终的复杂也就是 O(log(m+n）)
     *
     * 空间复杂度：虽然我们用到了递归，但是可以看到这个递归属于尾递归，
     *              所以编译器不需要不停地堆栈，所以空间复杂度为 O(1)
     */
    private static double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;

        int nums1Index = 0, nums2Index = 0;
        int k = length / 2;
        int index = 0;

        if (length == 3) {
            if (m == 2) {
                if (nums1[0] >= nums2[0]) {
                    return nums1[0];
                } else if (nums1[1] < nums2[0]) {
                    return nums1[1];
                } else {
                    return nums2[0];
                }
            } else {
                if (nums2[0] >= nums1[0]) {
                    return nums2[0];
                } else if (nums2[1] < nums1[0]) {
                    return nums2[1];
                } else {
                    return nums1[0];
                }
            }
        }

        if (m == 0) {
            if ((n & 1) == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }

        if (n == 0) {
            if ((m & 1) == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        while (k > 1) {
            index = k / 2;

            if (nums1Index + index >= m) {
                return nums2[nums2Index + index - m + nums1Index + 1];
            } else if (nums2Index + index >= n) {
                return nums1[nums1Index + index - n + nums2Index + 1];
            }

            if (nums1[nums1Index + index] < nums2[nums2Index + index]) {
                nums1Index += index;
            } else {
                nums2Index += index;
            }

            k -= index;
        }

        if (((m + n) & 1) == 0) {
            return (nums1[nums1Index] + nums2[nums2Index]) / 2.0;
        } else if (nums1[nums1Index] < nums2[nums2Index]) {
            return nums1[nums1Index];
        } else {
            return nums2[nums2Index];
        }
    }

}
