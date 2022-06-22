class Solution {
    public int maximalSquare(char[][] matrix) { // ��̬�滮������
        int m = matrix.length, n = matrix[0].length;
        int[][] d = new int[m+1][n+1]; // d[i][j]��ʾ��(i, j)Ϊ���½ǵġ����������߳����������ε���Ŀ��������
        int side = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 || j == 0) { // ת�Ʒ��̷��������������
                    d[i][j] = (matrix[i][j] == '0') ? 0 : 1;
                } else if (matrix[i][j] == '0') {
                    d[i][j] = 0;
                } else {
                    d[i][j] = Math.min(d[i][j-1], Math.min(d[i-1][j], d[i-1][j-1])) + 1;
                }
                side = Math.max(side, d[i][j]); // ������������α߳�������
            }
        }
        return side * side;
    }
}