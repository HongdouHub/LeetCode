package leetcode.t201_250.t225_MyStack.twice;

import leetcode.t201_250.t225_MyStack.MyStack;

import java.util.LinkedList;
import java.util.Queue;

public class MyTwiceStack2<E> implements MyStack<E> {

    private Queue<E> mQueue;
    private E mTop;

    public MyTwiceStack2() {
        mQueue = new LinkedList<>();
    }

    @Override
    public void push(E value) {
        mTop = value;
        mQueue.offer(value);
    }

    @Override
    public E pop() {
        Queue<E> queue = new LinkedList<>();
        E oldTop = mTop;
        int size = mQueue.size();

        // 不记录最后一个
        for (int i = 0; i < size - 1; i++) {
            queue.offer((mTop = mQueue.poll()));
        }
        mQueue = queue;
        return oldTop;
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
