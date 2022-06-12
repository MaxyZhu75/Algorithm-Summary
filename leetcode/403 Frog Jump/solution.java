class Solution {
    public boolean canCross(int[] stones) { // 考虑优化条件的动态规划！！！
        int n = stones.length;
        boolean[][] d = new boolean[n][n]; // 能否通过「跳跃距离distance」从「前一个编号为j的石子」达到「当前编号为i的石子」！！！
        d[0][0] = true;
        
		for (int i=1; i<n; i++) { // 每次跳跃之后跳跃距离至多增加1，到达编号i-1的石子时，之前至多跳了i-1次，下一跳至多跳 i 的距离！！！
            if (stones[i] - stones[i-1] > i) {
                return false; // 优化结论一：当编号i的石子与编号i-1的石子距离超过i时，青蛙必定无法到达终点，直接return！！！
            }
        }
		
		int distance = 0;
        for (int i=1; i<n; i++) {
            for (int j=i-1; j>=0; j--) {
                distance = stones[i] - stones[j];
                if (distance > j+1) { // 优化结论二：同理，到达编号j的石子时，下一跳至多跳j+1的距离！！！
                    break; // 由于倒序遍历j，若发现当前因为跳跃距离不够而无法到达，则直接break退出循环！！！
                }
                d[i][distance] = d[j][distance-1] || d[j][distance] || d[j][distance+1]; // 转移方程！！！
                if (i == n-1 && d[n-1][distance]) { // 到达终点！！！
                    return true;
                }
            }
        }
        return false;
    }
}
