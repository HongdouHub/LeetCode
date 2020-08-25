package leetcode.t703_KthLargest;

public class TestKthLargest {

    public static void main(String[] args) {
        int[] array = new int[] {4, 5, 8, 2};
        int k = 3;

        KthLargest kthLargest = new KthLargest(k, array);

        System.out.println(kthLargest.add(3));  // returns 4
        System.out.println(kthLargest.add(5));  // returns 5
        System.out.println(kthLargest.add(10)); // returns 5
        System.out.println(kthLargest.add(9));  // returns 8
        System.out.println(kthLargest.add(4));  // returns 8
    }
}
