class Solution {
    public int maxProfit(int k, int[] prices) { // 要点一：理解该题时始终记住，无论题目中是否允许「在同一天买入并且卖出」这一操作，最终的答案都不会受到影响，因为这一操作带来的收益为零！！！
        int n = prices.length;
        k = Math.min(k, n/2); // k的最大值可以达到10^9, 而n天最多只能进行n/2笔交易！！！
        if (k == 0) return 0;

        int[][] d = new int[n][2*k]; // DP的状态转换问题，k次交易可定义2*k个状态；理解该题时请与LeetCode123题k=2呼应！！！
        for (int j=0; j<2*k; j+=2) {
            d[0][j] = -prices[0]; // 要点二：第1天所有持股状态basecase！！！
        }
    
        for (int i=1; i<n; i++) { // 由于dp状态方程只与前一天状态有关，Go语言答案为空间优化版本！！！
            for (int j=0; j<2*k; j++) {
                if (j == 0) {  // 初始持股状态：第i天结束，此前从未进行过交易，手上持有第一次买操作的股票，记录此时最大收益！！！
                    d[i][0] = Math.max(d[i-1][0], -prices[i]);
                } else if (j % 2 == 0) {
                    d[i][j] = Math.max(d[i-1][j-1]-prices[i], d[i-1][j]); // 一般持股状态：第i天结束，完成j/2笔交易的前提下，手上持有第j/2+1次买操作的股票，记录此时最大收益！！！
                } else {
                    d[i][j] = Math.max(d[i-1][j-1]+prices[i], d[i-1][j]); // 一般空手状态：第i天结束，手上由于第j/2+1次买操作和第j/2+1次卖操作而不持有，记录此时最大收益！！！
                }
            }
        }

        return d[n-1][2*k-1]; // 要点三：dp方程会将前次交易的结果转移到最后的空手状态中！！！
    }
}