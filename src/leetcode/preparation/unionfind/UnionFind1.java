package leetcode.preparation.unionfind;

/**
 * Quick find
 *
 * @see #findRoot(int) ：        O(1)
 * @see #connected(int, int) ：  O(1)
 * @see #union(int, int) ：      O(n)
 */
public class UnionFind1 extends BaseUnionFind implements IUnionFind {

    public UnionFind1(int n) {
        super(n);
    }

    @Override
    public int findRoot(int p) {
        return mParents[p];
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

        for (int i = 0; i < mCount; i++) {
            if (mParents[i] == rootP) {
                mParents[i] = rootQ;
            }
        }
        mCount--;
    }
}
