package leetcode.t201_250.t225_MyStack;

import leetcode.t201_250.t225_MyStack.single.MySingleStack;
import leetcode.t201_250.t225_MyStack.single.MySingleStack2;
import leetcode.t201_250.t225_MyStack.twice.MyTwiceStack;
import leetcode.t201_250.t225_MyStack.twice.MyTwiceStack2;

/**
 * 用队列实现栈
 */
public class TestStack {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        MyStack<Integer> twiceStack = new MyTwiceStack<>();
        twiceStack.push(1);
        twiceStack.push(2);

        System.out.println(twiceStack.pop());    // 返回 2
        System.out.println(twiceStack.top());    // 返回 1
        System.out.println(twiceStack.empty());  // 返回 false
        System.out.println();

        MyStack<Integer> singleStack = new MySingleStack<>();
        singleStack.push(1);
        singleStack.push(2);

        System.out.println(singleStack.pop());    // 返回 2
        System.out.println(singleStack.top());    // 返回 1
        System.out.println(singleStack.empty());  // 返回 false
        System.out.println();
    }

    private static void test2() {
        MyStack<Integer> twiceStack = new MyTwiceStack2<>();
        twiceStack.push(1);
        twiceStack.push(2);

        System.out.println(twiceStack.pop());    // 返回 2
        System.out.println(twiceStack.top());    // 返回 1
        System.out.println(twiceStack.empty());  // 返回 false
        System.out.println();

        MyStack<Integer> singleStack = new MySingleStack2<>();
        singleStack.push(1);
        singleStack.push(2);

        System.out.println(singleStack.pop());    // 返回 2
        System.out.println(singleStack.top());    // 返回 1
        System.out.println(singleStack.empty());  // 返回 false
        System.out.println();
    }
}
