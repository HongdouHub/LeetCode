package leetcode.t151_200.t200_IsLands.union_find;

public class QuickUnionFind {
    private int[] roots;

    public QuickUnionFind(int n) {
        this.roots = new int[n];
        for (int i = 0; i < n; i++) {
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
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        roots[rootP] = rootQ;
    }
}
