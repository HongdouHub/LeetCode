package leetcode.t201_250.t225_MyStack;

public interface MyStack<E> {

    /** Push element x onto stack. */
    void push(E value);

    /** Removes the element on top of the stack and returns that element. */
    E pop();

    /** Get the top element. */
    E top();

    /** Returns whether the stack is empty. */
    boolean empty();
}
