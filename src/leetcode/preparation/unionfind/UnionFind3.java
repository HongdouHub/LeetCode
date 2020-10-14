package leetcode.preparation.unionfind;

import java.util.Arrays;

/**
 * Weighted quick union - 重量平衡
 *
 * @see #findRoot(int) ：        O(log n)
 * @see #connected(int, int) ：  O(log n)
 * @see #union(int, int) ：      O(log n)
 */
public class UnionFind3 extends BaseUnionFind implements IUnionFind {

    // 新增一个数组记录树的“重量”
    private int[] mSize;

    public UnionFind3(int n) {
        super(n);
        mSize = new int[n];
        Arrays.fill(mSize, 1);
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
        // 目标是少节点的root 要指向多节点的root
        if (size(rootP) <= size(rootQ)) {
            // 将 p 接到 q 上
            mParents[rootP] = rootQ;
            mSize[rootQ] += mSize[rootP];
        } else {
            // 将 q 接到 p 上
            mParents[rootQ] = rootP;
            mSize[rootP] += mSize[rootQ];
        }

        mCount--;
    }

    private int size(int p) {
        return mSize[p];
    }
}
