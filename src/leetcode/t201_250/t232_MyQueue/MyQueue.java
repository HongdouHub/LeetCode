package leetcode.t201_250.t232_MyQueue;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class MyQueue<E> {

    private Stack<E> mInputStack;
    private Stack<E> mOutputStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        mInputStack = new Stack<>();
        mOutputStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(E value) {
        while (!mOutputStack.isEmpty()) {
            mInputStack.push(mOutputStack.pop());
        }
        mInputStack.push(value);
    }

    /** Removes the element from in front of queue and returns that element. */
    public E pop() {
        if (mOutputStack.isEmpty()) {
            while (!mInputStack.isEmpty()) {
                mOutputStack.push(mInputStack.pop());
            }
        }
        return mOutputStack.isEmpty() ? null : mOutputStack.pop();
    }

    /** Get the front element. */
    public E peek() {
        if (mOutputStack.isEmpty()) {
            while (!mInputStack.isEmpty()) {
                mOutputStack.push(mInputStack.pop());
            }
        }
        return mOutputStack.isEmpty() ? null : mOutputStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mInputStack.isEmpty() && mOutputStack.isEmpty();
    }

}
