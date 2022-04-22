class Solution {
    public int kthFactor(int n, int k) { // 枚举优化方法；如果n有一个因子k，那它必然有另一个因子n/k，且这两个因子中至少有一个是小于等于根号n的！！！
        int count = 0;
        int factor = 1;
        while (factor*factor <= n) { // 从1到根号n找factor！！！
            if (n % factor == 0) count++;
            if (count == k) return factor;
            factor++;
        }

        factor--; // 要点：此处必须对factor变量进行该处理！！！
        if (factor*factor == n) factor--;

        while (factor >= 1) { // 从根号n到1往回遍历，但这次返回对应的另一个因子n/factor！！！
            if (n % factor == 0) count++;
            if (count == k) return n/factor;
            factor--;
        }

        return -1;
    }
}