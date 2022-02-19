class Solution { // 可按常规DP状态转换问题解决（见Go语言版本答案）；但此处由于交易次数无限制可以直接贪心（可与LeetCode188困难题作比较）！！！
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int result = 0;
        for (int i=1; i<n; i++) { // 要点：对于区间内四个数[a, b, c, d]，最大收益为 d - a；而 d - a = (d - c) + (c - b) + (b - a)！！！
            result += Math.max(0, prices[i]-prices[i-1]); // 贪心：对于prices[i]，若prices[i]-prices[i-1]>0，则直接把prices[i]-prices[i-1]添加到收益中！！！
        }
        return result;
    }
}