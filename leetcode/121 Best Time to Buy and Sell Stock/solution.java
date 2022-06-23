class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int currentMin = prices[0]; // 初始值为第一天股价！！！
        int maxProfit = 0;
        for (int i=0; i<n; i++) {
            if (prices[i] < currentMin) {
                currentMin = prices[i]; // if-else 结构即买与卖，且满足买和卖不能在同一天操作的条件！！！
            } else {
                maxProfit = Math.max(maxProfit, prices[i]-currentMin);
            }
        }
        return maxProfit;
    }
}
