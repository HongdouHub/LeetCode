package leetcode.preparation.unionfind;

public interface IUnionFind {

    /**
     * 获取联通分量
     */
    int count();

    /**
     * 找出 p 的根节点
     */
    int findRoot(int p);

    /**
     * 确认两个节点 p, q 是否是同一类
     */
    boolean connected(int p, int q);

    /**
     * 将 p 的根节点 指向 q 的根节点
     *
     * 表示两个节点 p, q 是一类，合并它们所在的树
     */
    void union(int p, int q);

    /**
     * 打印内部节点
     */
    void print();
}
