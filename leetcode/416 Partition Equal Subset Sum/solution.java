class Solution {
    public boolean canPartition(int[] nums) { // SubsetSum, Partition, 01Knapsack这三个npc问题DP的思路一致！！！
        int N = nums.length;
        int M = 0;
        for (int num : nums) {
            M += num;
        }
        if (M % 2 == 1) {
            return false;
        } else {
            M /= 2;
        }

        boolean[] d = new boolean[M+1]; // 要点一：一维数组形式下d[j]既表示d[i][j]，又表示d[i-1][j]（前i件物品状态仅与前i-1件物品状态有关）！！！
        d[0] = true; // basecase！！！

        for (int i=0; i<N; i++) {

            int num = nums[i];
            
            for (int j=M; j>=1; j--) { // 要点二：一维数组表示时内循环必须由大到小；因为若由小到大，更新d[j]时所取d[j-num]是被更新过的脏数据！！！
                if (j >= num) {
                    d[j] = d[j] || d[j-num]; // case1: d[i][j] = d[i-1][j] || d[i-1][j-num]！！！
                }                            // case2: d[i][j] = d[i-1][j]！！！
            }
        }

        return d[M];
    }
}