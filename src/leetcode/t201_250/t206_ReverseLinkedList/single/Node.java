package leetcode.t201_250.t206_ReverseLinkedList.single;

class Node<E> {

    protected E value;
    protected Node<E> next;

    public Node() {
        //
    }

    public Node(E value) {
        this.value = value;
    }

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }
}
