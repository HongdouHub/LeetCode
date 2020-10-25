package leetcode.t201_250.t225_MyStack.single;

import leetcode.t201_250.t225_MyStack.MyStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 普通队列
 */
public class MySingleStack<E> implements MyStack<E> {

    private Queue<E> mQueue;

    public MySingleStack() {
        mQueue = new LinkedList<>();
    }

    @Override
    public void push(E value) {
        int count = mQueue.size();

        mQueue.offer(value);
        while (count > 0) {
            mQueue.offer(mQueue.poll());
            count--;
        }
    }

    @Override
    public E pop() {
        return mQueue.poll();
    }

    @Override
    public E top() {
        return mQueue.peek();
    }

    @Override
    public boolean empty() {
        return mQueue.isEmpty();
    }
}
