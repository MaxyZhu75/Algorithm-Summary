public class Solution {
    public int coinChange(int[] coins, int amount) { // 经典动态规划问题！！！
        int[] d = new int[amount+1]; // d[i]表示组成金额i所需最少的硬币数量！！！
        Arrays.fill(d, amount+1);
        d[0] = 0;
        for (int i=1; i<=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j] <= i) {
                    d[i] = Math.min(d[i], d[i-coins[j]]+1);; // 转移方程：d[i] = min{d[i]...d[i-coins[j]]+1} ！！！
                }
            }
        }
        return d[amount] > amount ? -1 : d[amount];
    }
}