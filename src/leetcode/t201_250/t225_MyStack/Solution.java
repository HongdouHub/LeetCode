package leetcode.t201_250.t225_MyStack;

import leetcode.t201_250.t225_MyStack.single.MySingleStack;
import leetcode.t201_250.t225_MyStack.single.MySingleStack2;
import leetcode.t201_250.t225_MyStack.single.MySingleStack3;
import leetcode.t201_250.t225_MyStack.twice.MyTwiceStack;
import leetcode.t201_250.t225_MyStack.twice.MyTwiceStack2;

/**
 * 225. 用队列实现栈
 */
public class Solution {

    public static void main(String[] args) {
        test(MySingleStack.class);
        test(MySingleStack2.class);
        test(MySingleStack3.class);

        test(MyTwiceStack.class);
        test(MyTwiceStack2.class);
    }

    private static void testStack1(MyStack<Integer> stack) {
        stack.push(1);
        stack.push(2);

        System.out.println(stack.pop());    // 返回 2
        System.out.println(stack.top());    // 返回 1
        System.out.println(stack.empty());  // 返回 false
        System.out.println();
    }

    private static void testStack2(MyStack<Integer> stack) {
        stack.push(1);
        stack.push(2);

        System.out.println(stack.top());    // 返回 2
        System.out.println(stack.pop());    // 返回 2
        System.out.println(stack.empty());  // 返回 false
        System.out.println();
    }

    private static void test(Class clazz) {
        System.out.println(String.format("-------------%s------------", clazz.getSimpleName()));
        MyStack<Integer> stack = get(clazz);
        testStack1(stack);
        testStack2(stack);
        System.out.println("----------------------------------------\n");
    }

    private static MyStack<Integer> get(Class clazz) {
        MyStack<Integer> instance = null;
        try {
            instance = (MyStack<Integer>) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}
