package leetcode.preparation.unionfind;

/**
 * Quick union
 *
 * @see #findRoot(int) ：        O(n)
 * @see #connected(int, int) ：  O(n)
 * @see #union(int, int) ：      O(n)
 */
public class UnionFind2 extends BaseUnionFind implements IUnionFind {

    public UnionFind2(int n) {
        super(n);
    }

    @Override
    public int findRoot(int p) {
        while (p != mParents[p]) {
            p = mParents[p];
        }

        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    @Override
    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);

        if (rootP == rootQ) return;

        // 将两棵树合并为一颗
        mParents[rootP] = rootQ;
        mCount--;
    }
}
