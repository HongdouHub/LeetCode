package leetcode.preparation.unionfind;

public class Test {

    public static void main(String[] args) {

        IUnionFind find = new UnionFind4(5);
        System.out.println(find.findRoot(4));
    }

}
