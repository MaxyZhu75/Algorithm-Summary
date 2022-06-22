class Solution {
    public int numSquares(int n) { // 动态规划（类似找零钱问题）！！！
        int[] d = new int[n+1];
        for (int i=1; i<=n; i++) { // d[i]表示最少需要多少个数的平方来表示整数i！！！
            int minPre = Integer.MAX_VALUE;
            for (int j=1; j*j <= i; j++) {
                minPre = Math.min(minPre, d[i - j*j]);
            }
            d[i] = minPre + 1; // 转移方程：d[i] = min{d[i-j^2]}+1 ！！！
        }
        return d[n];
    }
}