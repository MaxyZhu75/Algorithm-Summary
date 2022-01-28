class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int p1 = 0, p2 = 0, result = 0; // 解题思路是排序后使用贪心思想；实现时借助双指针！！！
        Arrays.sort(g); // java.util.Arrays！！！
        Arrays.sort(s);
        while (p2 < s.length) { // 贪心内容:先用最小的饼干满足胃口最小的孩子，从而使被满足的孩子数量最多，正确性可由反证法简单证明！！！
            if (p1 > g.length-1) {
                return g.length;
            }
            if (s[p2] >= g[p1]) {
                p1++;
                p2++;
                result++;
            } else {
                p2++;
            }
        }
        return result;
    }
}