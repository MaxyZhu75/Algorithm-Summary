class Solution {
    public int maxCoins(int[] nums) { //「自底向上」动态规划！！！
        int n = nums.length;
        int[][] d = new int[n+2][n+2]; // d[i][j]表示在开区间(i,j)能得到的最多硬币数（气球i与气球j不戳破）！！！
        int[] coin = new int[n+2];
        coin[0] = coin[n+1] = 1; // 考虑边界的1，重新存储对应数值！！！
        for (int i=1; i<=n; i++) {
            coin[i] = nums[i-1];
        }
        for (int i=n-1; i>=0; i--) { // 要点：「左边界逆序」！！！
            for (int j=i+2; j<=n+1; j++) {
                for (int k=i+1; k<j; k++) { // 依次遍历戳破(i,j)之间的「气球k」所得到的硬币！！！
                    int current = coin[i] * coin[k] * coin[j] + d[i][k] + d[k][j];
                    d[i][j] = Math.max(d[i][j], current);
                }
            }
        }
        return d[0][n+1];
    }
}