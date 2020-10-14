package leetcode.t151_200.t200_IsLands.union_find;

public class UnionFind<T> {
    private UnionFind parent;
    private int rank;
    private T value;

    public UnionFind(T t) {
        value = t;
        parent = this;
    }

    public UnionFind findRoot(UnionFind x) {
        UnionFind root = parent;

        if (root.parent == parent)
            return root;
        else
            return findRoot(root.parent);
    }

    public boolean connected(UnionFind p, UnionFind q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(UnionFind p, UnionFind q) {
        UnionFind rootP = findRoot(p);
        UnionFind rootQ = findRoot(q);
        rootP.parent = rootQ;
    }

}
