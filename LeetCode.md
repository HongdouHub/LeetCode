## LeetCode 刷题总结





| 序号 | 题目序号                                                     | 题目解法                                                     | 复杂度                                                       |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)     | 哈希表                                                       | 时/空 - O(n)                                                 |
| 2    | [10. 正则表达式匹配 '.' 和 '*'](https://leetcode-cn.com/problems/regular-expression-matching/) | 动态规划                                                     | 时/空 - O(mn)                                                |
| 3    | [100. 相同的树](https://leetcode-cn.com/problems/same-tree/) | 递归深度/广度优先                                            | 时/空 - O(min(m,n))                                          |
| 4    | [1011. 在D天内送达包裹的能力](https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/) | 左右指针二分查找                                             | 时/空 - O(NlogN) / O(1)                                      |
| 5    | [111. 二叉树的最小深度](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | 递归深度/广度优先                                            | 时/空 - O(n) / O(log(n))                                     |
| 6    | [1118. 一月有多少天](https://leetcode-cn.com/problems/number-of-days-in-a-month/) | 闰年判断：能400整除，能4但不能100整除                        | 无                                                           |
| 7    | [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/) | 动态规划                                                     | 时/空 - O(mn)                                                |
| 8    | [130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/) | 递归深度                                                     | 时/空 - O(n) / O(1)                                          |
| 9    | [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/) | 哈希表<br>快慢指针                                           | 时/空 - O(n)<br>时/空 -  O(n)  /  O(1)                       |
| 10   | [142. 环形链表II](https://leetcode-cn.com/problems/linked-list-cycle-ii/) | 哈希表<br/>快慢指针                                          | 时/空 - O(n)<br/>时/空 - O(n)  /  O(1)                       |
| 11   | [146. LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/) | 双向哈希链表（get / put）                                    | 操作 - O(1)                                                  |
| 12   | [167. 两数之和 II - 输⼊有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/) | 左右指针二分查找                                             | 时/空 - O(NlogN) / O(1)                                      |
| 13   | [170. 两数之和 III - 数据结构设计](https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/) | 哈希表法                                                     | 时间<br/>add【O(1)】<br/>find【O(n)】<br>空间 - O(n)         |
|      | [170. 两数之和 III - 数据结构设计](https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/) | 左右指针二分查找                                             | 时间<br/>add【O(1)】<br/>find【O(n log(n))】<br/>空间 - O(n) |
| 14   | [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/) | 动态规划<br>滚动窗口                                         | 时/空  -  O(n)<br>时/空  -  O(n) / O(1)                      |
| 15   | [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/) | 暴力循环                                                     | 时/空  -  O(n)                                               |
| 16   | [204. 计数质数](https://leetcode-cn.com/problems/count-primes/) | 暴力求解<br>高效算法 - Sieve of Eratosthenes                 | 时/空  -  O(n^2)  / O(1)<br>时/空  -  O(N*logN)/ O(1)        |
| 17   | [213. 打家劫舍II](https://leetcode-cn.com/problems/house-robber-ii/) | 动态规划                                                     | 时/空  -  O(n)                                               |
| 18   | [22. 括号⽣成](https://leetcode-cn.com/problems/generate-parentheses/) | 递归深度/广度优先<br>动态规划                                | 时/空  - O(n^2)                                              |
| 19   | [222. 完全⼆叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes/) | 暴力递归<br>左右指针二分查找                                 | 时/空 -O(n)/O(logn)<br>时/空                                 |
| 20   | [224. 基本计算器](https://leetcode-cn.com/problems/basic-calculator/) | 栈和反转字符串<br>通用解法                                   | 时/空 -  O(n)<br>时/空 -  O(n)                               |
| 21   | [225. ⽤队列实现栈](https://leetcode-cn.com/problems/implement-stack-using-queues) | 单队列<br>Queue、Deque【LinkedList】<br/>双队列<br/>Queue【ArrayDeque】 | 时/空 -                                                      |
| 22   | [227. 基本计算器II](https://leetcode-cn.com/problems/basic-calculator-ii/) | 通用解法                                                     | 时/空 -  O(n)<br/>时/空 -  O(n)                              |
| 23   | [232. ⽤栈实现队列](https://leetcode-cn.com/problems/implement-queue-using-stacks/) | 双栈模拟                                                     |                                                              |
| 24   | [234. 回⽂链表](https://leetcode-cn.com/problems/palindrome-linked-list/) | 将值复制到数组中后用双指针法<br>反转后半部分链表             | 时/空 - O(n)<br>时/空 - O(n) / O(1)                          |
| 25   | [236. ⼆叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/) | 递归深度优先                                                 | 时/空 - O(n)                                                 |
| 26   | [239. 滑动窗⼝最⼤值](https://leetcode-cn.com/problems/sliding-window-maximum/) | 双端队列                                                     | 时/空 - O(n)                                                 |
| 27   | [25. K个⼀组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/) | 翻转部分链表                                                 | 时/空 - O(n)                                                 |
| 28   | [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/) | 暴力修改                                                     |                                                              |
| 29   | [28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/) | 暴力求解                                                     | 时/空 - O(mn)                                                |
| 30   | [292. Nim游戏](https://leetcode-cn.com/problems/nim-game/)   | 不能被4整除                                                  |                                                              |
| 31   | [3. ⽆重复字符的最长⼦串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/) | 哈希表                                                       | 时/空 - O(n)                                                 |
| 32   | [300. 最长上升⼦序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/) | 动态规划<br>二分查找                                         | 时/空 - O(n^2) / O(n)<br>时/空 - O(N·logN) / O(n)            |
| 33   | [312. 戳⽓球](https://leetcode-cn.com/problems/burst-balloons/) | 记忆化搜索<br>动态规划                                       | 时/空 - O(n^3) / O(n^2)<br>时/空 - O(n^3) / O(n^2)           |
| 34   | [319. 灯泡开关](https://leetcode-cn.com/problems/bulb-switcher/) | 1. 亮与否，跟操作次数有关<br>2. 操作次数就是该数的因数个数<br>3. 因数为奇数则亮灯<br>4. 奇数表明该位置是完全平方数<br>5. 计算有多少个完全平方数 |                                                              |
| 35   | [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/) | 动态规划                                                     | 时/空 - O(mn) / O(n)                                         |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |
|      |                                                              |                                                              |                                                              |



