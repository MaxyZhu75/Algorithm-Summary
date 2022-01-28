class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; // ����������
        int n = grid[0].length; // ����������
        
        int[][] d = new int[m][n]; // ������άdp������
        
		d[0][0] = grid[0][0]; // basecase������
        for (int i=1; i<m; i++) { // ����������dp��Ĵ�С��ԭ������ͬʱ�߼�������������ı߽���Ҫ����basecase������������ѭ��Ϊ�߽縳ֵ������
            d[i][0] = d[i-1][0] + grid[i][0];
        }
        for (int j=1; j<n; j++) {
            d[0][j] = d[0][j-1] + grid[0][j];
        }
        
		for (int i=1; i<m; i++) { // dp��������ɣ�����
            for (int j=1 ; j<n; j++) {
                d[i][j] = Math.min(d[i-1][j], d[i][j-1]) + grid[i][j];
            }
        }
        
		return d[m-1][n-1];
    }
}