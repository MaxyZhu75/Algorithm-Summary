class Solution {
    public int maxCoins(int[] nums) { //���Ե����ϡ���̬�滮������
        int n = nums.length;
        int[][] d = new int[n+2][n+2]; // d[i][j]��ʾ�ڿ�����(i,j)�ܵõ������Ӳ����������i������j�����ƣ�������
        int[] coin = new int[n+2];
        coin[0] = coin[n+1] = 1; // ���Ǳ߽��1�����´洢��Ӧ��ֵ������
        for (int i=1; i<=n; i++) {
            coin[i] = nums[i-1];
        }
        for (int i=n-1; i>=0; i--) { // Ҫ�㣺����߽����򡹣�����
            for (int j=i+2; j<=n+1; j++) {
                for (int k=i+1; k<j; k++) { // ���α�������(i,j)֮��ġ�����k�����õ���Ӳ�ң�����
                    int current = coin[i] * coin[k] * coin[j] + d[i][k] + d[k][j];
                    d[i][j] = Math.max(d[i][j], current);
                }
            }
        }
        return d[0][n+1];
    }
}