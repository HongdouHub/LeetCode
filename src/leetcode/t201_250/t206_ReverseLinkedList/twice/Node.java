package leetcode.t201_250.t206_ReverseLinkedList.twice;

class Node<E> {

    protected E value;
    protected Node<E> prev;
    protected Node<E> next;


    public Node() {
        //
    }

    public Node(E value) {
        this.value = value;
    }

    public Node(E value, Node<E> prev, Node<E> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
