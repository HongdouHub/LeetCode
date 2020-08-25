package leetcode.t201_250.t225_MyStack.single;

import leetcode.t201_250.t225_MyStack.MyStack;

import java.util.LinkedList;
import java.util.Queue;

public class MySingleStack2<E> implements MyStack<E> {

    private Queue<E> mQueue;
    private E mTop;

    public MySingleStack2() {
        mQueue = new LinkedList<>();
    }

    @Override
    public void push(E value) {
        mTop = value;
        mQueue.offer(value);
    }

    @Override
    public E pop() {
        int size = mQueue.size();
        for (int i = 0; i < size - 1; i++) {
            mQueue.offer((mTop = mQueue.poll()));
        }
        return mQueue.poll();
    }

    @Override
    public E top() {
        return mTop;
    }

    @Override
    public boolean empty() {
        return mQueue.isEmpty();
    }
}
