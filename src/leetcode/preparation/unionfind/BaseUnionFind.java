package leetcode.preparation.unionfind;

import utils.GsonUtil;

import java.util.Arrays;

@SuppressWarnings("all")
public abstract class BaseUnionFind implements IUnionFind {

    protected int mCount;       // 记录连通分量
    protected int[] mParents;    // 节点 p 的父节点是 mParents[p]

    public BaseUnionFind(int n) {
        this.mCount = n;

        // 一开始互不连通
        this.mParents = new int[n];
        for (int i = 0; i < n; i++) {
            mParents[i] = i;
        }
    }

    public int count() {
        return mCount;
    }

    @Override
    public void print() {
        System.out.println(GsonUtil.array2Json(Arrays.asList(mParents)));
    }
}
