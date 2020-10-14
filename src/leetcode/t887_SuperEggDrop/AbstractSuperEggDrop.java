package leetcode.t887_SuperEggDrop;

public abstract class AbstractSuperEggDrop implements ISuperEggDrop {

    /**
     * 做初级二分计算
     * @param K 鸡蛋数
     * @param N 楼层数
     */
    @Override
    public int superEggDrop(int K, int N) {
        int depth = getDepth(N);
        return K >= depth ? depth : -1;
    }

    /**
     * 计算出该楼层，全量做二分计算，最大的计算次数
     * @param N 楼层数
     */
    private int getDepth(int N) {
        int count = 0;
        while (N > 0) {
            count++;
            N /= 2;
        }
        return count;
    }
}
