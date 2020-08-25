package leetcode.t151_200.t200_IsLands.union_find;

public class QuickUnionFind {
    private int[] roots;

    public QuickUnionFind(int N) {
        this.roots = new int[N];
        for (int i = 0; i < N; i++) {
            roots[i] = i;
        }
    }

    public int findRoot(int i) {
        int root = i;
        while (root != roots[root])
            root = roots[root];
        while (i != roots[i]) {
            int temp = roots[i];
            roots[i] = root;
            i = temp;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int proot = findRoot(p);
        int qroot = findRoot(q);
        roots[proot] = qroot;
    }
}
