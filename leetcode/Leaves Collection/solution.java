class Solution {
    public int minimumOperations(String leaves) { // 动态规划！！！
        int n = leaves.length();
        int[][] d = new int[n][3]; // 三种状态！！！
        d[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        d[0][1] = d[0][2] = d[1][2] = Integer.MAX_VALUE; // 细节：所有「i<j」的状态都是不符合要求的！！！
        for (int i=1; i<n; i++) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            d[i][0] = d[i-1][0] + isYellow;
            d[i][1] = Math.min(d[i-1][0], d[i-1][1]) + isRed;
            if (i >= 2) {
                d[i][2] = Math.min(d[i-1][1], d[i-1][2]) + isYellow;
            }
        }
        return d[n-1][2];
    }
}