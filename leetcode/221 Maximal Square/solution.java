class Solution {
    public int maximalSquare(char[][] matrix) { // 动态规划！！！
        int m = matrix.length, n = matrix[0].length;
        int[][] d = new int[m+1][n+1]; // d[i][j]表示以(i, j)为右下角的「正方形最大边长」或「正方形的数目」！！！
        int side = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 || j == 0) { // 转移方程分三种情况！！！
                    d[i][j] = (matrix[i][j] == '0') ? 0 : 1;
                } else if (matrix[i][j] == '0') {
                    d[i][j] = 0;
                } else {
                    d[i][j] = Math.min(d[i][j-1], Math.min(d[i-1][j], d[i-1][j-1])) + 1;
                }
                side = Math.max(side, d[i][j]); // 更新最大正方形边长！！！
            }
        }
        return side * side;
    }
}