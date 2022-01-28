class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; // 行数！！！
        int n = grid[0].length; // 列数！！！
        
        int[][] d = new int[m][n]; // 创建二维dp表！！！
        
		d[0][0] = grid[0][0]; // basecase！！！
        for (int i=1; i<m; i++) { // 该题所创建dp表的大小与原数组相同时逻辑更清晰，但表的边界需要视作basecase，即先用两个循环为边界赋值！！！
            d[i][0] = d[i-1][0] + grid[i][0];
        }
        for (int j=1; j<n; j++) {
            d[0][j] = d[0][j-1] + grid[0][j];
        }
        
		for (int i=1; i<m; i++) { // dp方程填表即可！！！
            for (int j=1 ; j<n; j++) {
                d[i][j] = Math.min(d[i-1][j], d[i][j-1]) + grid[i][j];
            }
        }
        
		return d[m-1][n-1];
    }
}