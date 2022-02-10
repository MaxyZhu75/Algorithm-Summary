class Solution {
    public int maxProfit(int[] prices, int fee) { // DP的状态转换问题，关键弄清楚几个状态及状态含义；与LeetCode309题类似！！！
        int n = prices.length;
        int[][] d = new int[n][2];

        d[0][0] = -prices[0]; // basecase！！！
        d[0][1] = 0;
        for (int i=1; i<n; i++) { // 由于dp状态方程只与前一天状态有关，Go语言答案为空间优化版本！！！
            d[i][0] = Math.max(d[i-1][0], d[i-1][1]-prices[i]); // 状态0：第i天结束，手上持有着股票，记录此时最大收益！！！
            d[i][1] = Math.max(d[i-1][0]+prices[i]-fee, d[i-1][1]); // 状态1：第i天结束，手上不持有股票，记录此时最大收益！！！
        }

        return d[n-1][1]; // 最后一天希望收益最大，手上股票肯定已丢出跑路，不会再买来烂在荷包里！！！
    }
}