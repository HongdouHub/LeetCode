package leetcode.preparation.linkednode;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ListNode)) {
            return false;
        }

        ListNode node = (ListNode) obj;
        return this.val == node.val;
    }

    @Override
    public int hashCode() {
        return val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
