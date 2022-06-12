class Solution { // ���䶯̬�滮���⣡����
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n]; // d[i][j]��ʾ��(0,0)�ߵ�(i,j)��·������������
        for (int i=0; i<m; i++) { // �Ƚ��߽���1������
            d[i][0] = 1;
        }
        for (int j=0; j<n; j++) {
            d[0][j] = 1;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                d[i][j] = d[i-1][j] + d[i][j-1]; // ת�Ʒ��̣�ֻ�ܴ��Ϸ����󷽸�����һ�����ﵱǰ���ӣ�����
            }
        }
        return d[m-1][n-1];
    }
}