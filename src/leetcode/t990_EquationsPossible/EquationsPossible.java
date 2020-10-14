package leetcode.t990_EquationsPossible;

import leetcode.preparation.unionfind.IUnionFind;
import leetcode.preparation.unionfind.UnionFind4;

import static utils.ConsoleUtils.println;

/**
 * 990. 等式方程的可满足性
 *
 * 给定一个由表示变量之间关系的字符串方程组成的数组，
 * 每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。
 * 在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 */
public class EquationsPossible {

    public static void main(String[] args) {
        println(equationsPossible(new String[]{"a==b", "b!=a"}));    // false
        println(equationsPossible(new String[]{"b==a", "a==b"}));    // true
        println(equationsPossible(new String[]{"a==b", "b==c", "a==c"}));    // true
        println(equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));    // false
        println(equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));    // true
    }

    // 并查集
    private static boolean equationsPossible(String[] equations) {
        // 小写字母 26
        IUnionFind unionFind = new UnionFind4(26);

        // 先让相等的字母形成连通分量
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char char1 = equation.charAt(0);
                char char2 = equation.charAt(3);
                unionFind.union(char1 - 'a', char2 - 'a');
            }
        }

        // 检查不等关系是否打破相等关系的连通性
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char char1 = equation.charAt(0);
                char char2 = equation.charAt(3);
                boolean connected = unionFind.connected(char1 - 'a', char2 - 'a');
                // 如果相等关系成立，就是逻辑冲突
                if (connected) {
                    return false;
                }
            }
        }

        return true;
    }

}
