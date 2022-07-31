class Solution {
	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) { // 本题不能用回溯，因为球可以在某两点往复移动！！！
        if (maxMove == 0) return 0;
        int[][] curDP = new int[m+2][n+2], preDP = new int[m+2][n+2]; // 需要记录原状态的DP表，curDP与preDP交换状态！！！
        for (int i=1; i<=m; i++) {
            curDP[i][1]++;
            curDP[i][n]++;
        }
        for (int j=1; j<=n; j++) {
            curDP[1][j]++;
            curDP[m][j]++;
        }
        int result = curDP[startRow+1][startColumn+1];
        for (int k=1; k<maxMove; k++) {
            int[][] temp = curDP;
            curDP = preDP;
            preDP = temp;
            for (int i=1; i<=m; i++) {
                for (int j=1; j<=n; j++) {
                    curDP[i][j] = (int)(((long)preDP[i-1][j] + preDP[i+1][j] + preDP[i][j-1] + preDP[i][j+1]) % 1000000007L);
				}
			}
			result = (result + curDP[startRow+1][startColumn+1]) % 1000000007;
        }
        return result;
    }
}