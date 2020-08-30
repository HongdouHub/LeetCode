package leetcode.t201_250.t225_MyStack;

import leetcode.t201_250.t225_MyStack.single.MySingleStack;
import leetcode.t201_250.t225_MyStack.single.MySingleStack2;
import leetcode.t201_250.t225_MyStack.single.MySingleStack3;
import leetcode.t201_250.t225_MyStack.twice.MyTwiceStack;
import leetcode.t201_250.t225_MyStack.twice.MyTwiceStack2;

/**
 * 用队列实现栈
 */
public class TestStack {

    public static void main(String[] args) {
//        testStack(new MyTwiceStack<>());
//        testStack(new MySingleStack<>());
//
//        testStack(new MyTwiceStack2<>());
//        testStack(new MySingleStack2<>());

        testStack1(new MySingleStack3<>());
    }

    private static void testStack(MyStack<Integer> stack) {
        stack.push(1);
        stack.push(2);

        System.out.println(stack.pop());    // 返回 2
        System.out.println(stack.top());    // 返回 1
        System.out.println(stack.empty());  // 返回 false
        System.out.println();
    }

    private static void testStack1(MyStack<Integer> stack) {
        stack.push(1);
        stack.push(2);

        System.out.println(stack.top());    // 返回 2
        System.out.println(stack.pop());    // 返回 2
        System.out.println(stack.empty());  // 返回 false
        System.out.println();
    }
}
