package leetcode.t201_250.t232_MyQueue;

/**
 * 用栈实现队列
 */
public class TestQueue {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.empty()); // 返回 false
    }

}
