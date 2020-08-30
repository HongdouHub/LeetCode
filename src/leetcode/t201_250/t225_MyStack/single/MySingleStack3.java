package leetcode.t201_250.t225_MyStack.single;

import leetcode.t201_250.t225_MyStack.MyStack;

import java.util.Deque;
import java.util.LinkedList;

public class MySingleStack3<E> implements MyStack<E> {

    /**
     * 双端队列
     *
     * #offer 尾部插入元素
     *
     * #peekLast 取出尾指针元素
     * #pollLast 取出并移除尾指针元素
     *
     * #peek 取出头指针元素
     * #poll 取出并移除头指针元素
     */
    private Deque<E> deque;

    public MySingleStack3() {
        deque = new LinkedList<>();
    }

    @Override
    public void push(E value) {
        deque.offer(value);
    }

    @Override
    public E pop() {
        // 取出并移除尾指针元素
        return deque.pollLast();
    }

    @Override
    public E top() {
        // 取出尾指针元素
        return deque.peekLast();
    }

    @Override
    public boolean empty() {
        return deque.isEmpty();
    }
}
