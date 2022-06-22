class Solution {
    public int numSquares(int n) { // 「四平方和定理」数学解法；算法正确性证明见官方题解！！！
        if (isSquare(n)) {
            return 1;
        }
        if (isCase4(n)) {
            return 4;
        }
        for (int i=1; i*i <= n; i++) {
            int j = n - i*i;
            if (isSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    public boolean isSquare(int n) { // 判断是否为完全平方数！！！
        int a = (int)Math.sqrt(n);
        return a*a == n;
    }

    public boolean isCase4(int n) { // 判断是否满足「n = 4^k*(8m+7)」！！！
        while (n % 4 == 0) {
            n /= 4;
        }
        return n % 8 == 7;
    }
}