package leetcode.t201_250.t225_MyStack.twice;

import leetcode.t201_250.t225_MyStack.MyStack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyTwiceStack<E> implements MyStack<E> {

    private Queue<E> mInputQueue;
    private Queue<E> mOutputQueue;

    public MyTwiceStack() {
        // 阻塞队列
        LinkedBlockingQueue queue;

        mInputQueue = new ArrayDeque<>();
        mOutputQueue = new ArrayDeque<>();
    }

    @Override
    public void push(E value) {
        mInputQueue.offer(value);

        while (!mOutputQueue.isEmpty()) {
            mInputQueue.offer(mOutputQueue.poll());
        }

        while (!mInputQueue.isEmpty()) {
            mOutputQueue.offer(mInputQueue.poll());
        }
    }

    @Override
    public E pop() {
        return mOutputQueue.poll();
    }

    @Override
    public E top() {
        return mOutputQueue.peek();
    }

    @Override
    public boolean empty() {
        return mOutputQueue.isEmpty();
    }
}
