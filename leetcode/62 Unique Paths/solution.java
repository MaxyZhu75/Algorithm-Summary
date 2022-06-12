class Solution { // 经典动态规划问题！！！
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n]; // d[i][j]表示从(0,0)走到(i,j)的路径数量！！！
        for (int i=0; i<m; i++) { // 先将边界填1！！！
            d[i][0] = 1;
        }
        for (int j=0; j<n; j++) {
            d[0][j] = 1;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                d[i][j] = d[i-1][j] + d[i][j-1]; // 转移方程；只能从上方或左方格子走一步到达当前格子！！！
            }
        }
        return d[m-1][n-1];
    }
}