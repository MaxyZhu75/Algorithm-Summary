class Solution {
    public int integerBreak(int n) {
        int[] d = new int[n+1]; // 创建dp表！！！
        d[0] = 0; d[1] = 1; // basecase！！！
        for (int i=2; i<=n; i++) { // 外层：把dp表填满的循环！！！
            for (int j=1; j<i; j++) { // 内层：在填表的某一格时需要遍历所有可能的情况！！！
                d[i] = triMax(d[i], d[i-j]*j, (i-j)*j); // 此处有三种case，尤其最后一种易漏，因为由定义可知此处 0 < i-j < i，故i-j对于i是合理的拆分，而这种拆分d[i-j]并未包括！！！
            }
        }
        return d[n];
    }

    public int triMax(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }
}