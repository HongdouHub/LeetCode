package leetcode.preparation.unionfind;

import java.util.Arrays;

/**
 * Path compression quick union - 路径压缩
 *
 * @see #findRoot(int) ：        O(1)
 * @see #connected(int, int) ：  O(1)
 * @see #union(int, int) ：      O(1)
 */
public class UnionFind4 extends BaseUnionFind {

    // 新增一个数组记录树的“重量”
    private int[] mSize;

    public UnionFind4(int n) {
        super(n);
        mSize = new int[n];
        Arrays.fill(mSize, 1);
    }

    @Override
    public int findRoot(int p) {
        while (p != mParents[p]) {
            mParents[p] = mParents[mParents[p]];
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
        if (mSize[rootP] <= mSize[rootQ]) {
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
}
